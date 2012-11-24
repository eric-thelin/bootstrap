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

    private MessageCatalog catalog;

    @Before
    public void setUp() {
	catalog = mock(MessageCatalog.class);
	MessageUtility.use(catalog);
    }

    @Test(expected = NullArgumentException.class)
    public void throwsWhenUsingNullCatalog() {
	MessageUtility.use(null);
    }

    @Test
    public void returnsMessageEvenIfNoCatalogHasBeenConfigured() {
	MessageUtility.reset();

	assertThat(MessageUtility.messageFor(NullArgumentException.class),
		is(equalTo("Null argument")));
    }

    @Test(expected = NullArgumentException.class)
    public void throwsWhenClassIsNull() {
	MessageUtility.messageFor(null);
    }

    @Test
    public void throwsWhenCatalogThrows() {
	Exception exception = anException();
	given(catalog.messageFor(any(Class.class))).willThrow(exception);

	try {
	    MessageUtility.messageFor(MessageUtility.class);
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
	given(catalog.messageFor(MessageUtility.class)).willReturn("A message");
	given(catalog.messageFor(MessageUtilityTest.class)).willReturn(
		"Another message");

	assertThat(MessageUtility.messageFor(MessageUtility.class),
		is(equalTo("A message")));
	assertThat(MessageUtility.messageFor(MessageUtilityTest.class),
		is(equalTo("Another message")));
    }
}