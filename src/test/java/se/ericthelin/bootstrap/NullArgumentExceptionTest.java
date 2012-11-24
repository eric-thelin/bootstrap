package se.ericthelin.bootstrap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class NullArgumentExceptionTest {

    @Test
    public void getsMessageFromCatalog() {
	MessageCatalog catalog = mock(MessageCatalog.class);
	MessageUtility.use(catalog);

	given(catalog.messageFor(NullArgumentException.class))
		.willReturn("foo");

	assertThat(new NullArgumentException().getMessage(), is(equalTo("foo")));
    }

}
