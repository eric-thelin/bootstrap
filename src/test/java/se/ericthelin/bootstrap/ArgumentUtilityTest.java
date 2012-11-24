package se.ericthelin.bootstrap;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ArgumentUtilityTest {

    @Test(expected = NullArgumentException.class)
    public void notNullThrowsWhenArgumentIsNull() {
	ArgumentUtility.verifyNotNull(null);
    }

    @Test
    public void notNullReturnsArgumentWhenArgumentIsNotNull() {
	String argument = "foo";

	String actual = ArgumentUtility.verifyNotNull(argument);

	assertThat(actual, is(sameInstance(argument)));
    }
}
