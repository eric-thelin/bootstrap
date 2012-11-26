package se.ericthelin.bootstrap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class NullArgumentExceptionTest {

    @Test
    public void getsMessageFromFactory() {
	MessageFactory factory = mock(MessageFactory.class);
	MessageUtility.use(factory);

	given(factory.createMessage(NullArgumentException.class)).willReturn(
		"foo");

	assertThat(new NullArgumentException().getMessage(), is(equalTo("foo")));
    }

}
