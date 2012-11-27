package se.ericthelin.bootstrap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static se.ericthelin.bootstrap.FluentMessageDescription.identifiedBy;

import org.junit.Before;
import org.junit.Test;

public class MessageUtilityTest {

    private MessageFactory factory;

    @Before
    public void setUp() {
	factory = mock(MessageFactory.class);
	MessageUtility.use(factory);
    }

    @Test(expected = NullArgumentException.class)
    public void throwsWhenUsingNullFactory() {
	MessageUtility.use(null);
    }

    @Test
    public void returnsMessageEvenIfNoFactoryHasBeenConfigured() {
	MessageUtility.reset();

	assertThat(MessageUtility.createMessage(identifiedBy("id")),
		is(notNullValue()));
    }

    @Test(expected = NullArgumentException.class)
    public void throwsWhenClassIsNull() {
	MessageUtility.createMessage(null);
    }

    @Test
    public void throwsWhenFactoryThrows() {
	Exception exception = anException();
	given(factory.createMessage(any(MessageDescription.class))).willThrow(
		exception);

	try {
	    MessageUtility.createMessage(identifiedBy("id"));
	    fail("No exception thrown");
	} catch (Exception e) {
	    assertThat(e, is(sameInstance(exception)));
	}
    }

    private Exception anException() {
	return new RuntimeException();
    }

    @Test
    public void returnsClassSpecificMessages() {
	MessageDescription firstDescription = identifiedBy("id-1");
	MessageDescription secondDescription = identifiedBy("id-2");

	given(factory.createMessage(firstDescription)).willReturn("A message");
	given(factory.createMessage(secondDescription)).willReturn(
		"Another message");

	assertThat(MessageUtility.createMessage(firstDescription),
		is(equalTo("A message")));
	assertThat(MessageUtility.createMessage(secondDescription),
		is(equalTo("Another message")));
    }
}