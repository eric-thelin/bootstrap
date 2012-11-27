package se.ericthelin.bootstrap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static se.ericthelin.bootstrap.FluentMessageDescription.identifiedBy;

import org.junit.Test;

public class ParameterMappingMessageFactoryTest {

    @Test
    public void echoesDescription() {
	ParameterMappingMessageFactory factory = new ParameterMappingMessageFactory();

	assertThat(factory.createMessage(identifiedBy("id")), is(equalTo("id")));
	assertThat(
		factory.createMessage(identifiedBy("id").havingParameter("a",
			"foo")), is(equalTo("id: a=\"foo\"")));
	assertThat(
		factory.createMessage(identifiedBy("id").havingParameter("a",
			"foo").havingParameter("b", "bar")),
		is(equalTo("id: a=\"foo\", b=\"bar\"")));
    }
}
