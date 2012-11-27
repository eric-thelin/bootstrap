package se.ericthelin.bootstrap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

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

	assertThat(MessageUtility.createMessage(NullArgumentException.class),
		is(equalTo("Null argument")));
    }

    @Test(expected = NullArgumentException.class)
    public void throwsWhenClassIsNull() {
	MessageUtility.createMessage(null);
    }

    @Test
    public void throwsWhenFactoryThrows() {
	Exception exception = anException();
	given(factory.createMessage(any(Class.class))).willThrow(exception);

	try {
	    MessageUtility.createMessage(MessageUtility.class);
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
	given(factory.createMessage(MessageUtility.class)).willReturn(
		"A message");
	given(factory.createMessage(MessageUtilityTest.class)).willReturn(
		"Another message");

	assertThat(MessageUtility.createMessage(MessageUtility.class),
		is(equalTo("A message")));
	assertThat(MessageUtility.createMessage(MessageUtilityTest.class),
		is(equalTo("Another message")));
    }
}