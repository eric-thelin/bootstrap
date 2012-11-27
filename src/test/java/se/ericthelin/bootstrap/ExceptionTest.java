package se.ericthelin.bootstrap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ExceptionTest {

    @Test
    public void getNameReturnsFullyQualifiedName() {
	assertThat(NullArgumentException.class.getName(),
		is(equalTo("se.ericthelin.bootstrap.NullArgumentException")));
    }
}
