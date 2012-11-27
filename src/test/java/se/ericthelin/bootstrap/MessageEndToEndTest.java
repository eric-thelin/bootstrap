package se.ericthelin.bootstrap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class MessageEndToEndTest {

    @Before
    public void setUp() {

    }

    @Test
    public void createsMessageFromProperty() {
	Properties properties = new Properties();
	properties.put(NullArgumentException.class.getName(),
		"Argument is null");

	MessageUtility.use(new PropertiesMessageFactory(properties,
		new ParameterMappingMessageFactory()));

	assertThat(new NullArgumentException().getMessage(),
		is(equalTo("Argument is null")));
    }

    @Test
    public void delegatesToOtherFactoryWhenPropertyNotFound() {
	Properties properties = new Properties();

	MessageUtility.use(new PropertiesMessageFactory(properties,
		new ParameterMappingMessageFactory()));

	assertThat(new NullArgumentException().getMessage(),
		is(equalTo("<no arguments>")));
    }
}
