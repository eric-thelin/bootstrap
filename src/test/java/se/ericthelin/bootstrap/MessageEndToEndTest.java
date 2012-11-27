package se.ericthelin.bootstrap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static se.ericthelin.bootstrap.FluentMessageDescription.identifiedBy;

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
		new ClassNameMessageFactory()));

	assertThat(new NullArgumentException().getMessage(),
		is(equalTo("Argument is null")));
    }

    @Test
    public void createsParameterizedMessageFromProperty() {
	Properties properties = new Properties();
	properties.put(ParameterizedObject.class.getName(),
		"a: <${a}>, b: <${b}>");

	MessageUtility.use(new PropertiesMessageFactory(properties,
		new ClassNameMessageFactory()));

	assertThat(new ParameterizedObject("foo", "bar").getMessage(),
		is(equalTo("a: <foo>, b: <bar>")));
    }

    @Test
    public void delegatesToOtherFactoryWhenPropertyNotFound() {
	Properties properties = new Properties();

	MessageUtility.use(new PropertiesMessageFactory(properties,
		new ClassNameMessageFactory()));

	assertThat(new NullArgumentException().getMessage(),
		is(equalTo("Null argument")));
    }

    private static class ParameterizedObject {

	private final Object a;
	private final Object b;

	public ParameterizedObject(Object a, Object b) {
	    this.a = a;
	    this.b = b;
	}

	public String getMessage() {
	    return MessageUtility.createMessage(identifiedBy(this.getClass())
		    .havingParameter("a", a).havingParameter("b", b));
	}

    }
}
