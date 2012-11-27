package se.ericthelin.bootstrap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static se.ericthelin.bootstrap.FluentMessageDescription.identifiedBy;

import org.junit.Test;

public class ClassNameMessageFactoryTest {

    @Test
    public void messageIsDerivedFromClassName() {
	MessageFactory factory = new ClassNameMessageFactory();

	assertThat(
		factory.createMessage(identifiedBy(NullArgumentException.class)),
		is(equalTo("Null argument")));

	assertThat(
		factory.createMessage(identifiedBy(IllegalStateException.class)),
		is(equalTo("Illegal state")));
    }

}
