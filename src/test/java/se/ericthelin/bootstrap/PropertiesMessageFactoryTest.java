package se.ericthelin.bootstrap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static se.ericthelin.bootstrap.FluentMessageDescription.identifiedBy;

import java.util.Properties;
import java.util.regex.Pattern;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

public class PropertiesMessageFactoryTest {

    @Test
    public void testPlaceholderPattern() {
	assertThat(PropertiesMessageFactory.PLACEHOLDER_PATTERN,
		matches("${apa}"));
    }

    private Matcher<Pattern> matches(final String text) {
	return new TypeSafeMatcher<Pattern>() {

	    @Override
	    public void describeTo(Description description) {
		description.appendText("matches ").appendValue(text);

	    }

	    @Override
	    protected boolean matchesSafely(Pattern item) {
		return item.matcher(text).matches();
	    }
	};
    }

    @Test
    public void replacesPlaceholdersWithActualValues() {
	Properties properties = new Properties();
	properties.put("id", "Message: a='${a}', b='${b}'");

	PropertiesMessageFactory factory = new PropertiesMessageFactory(
		properties, mock(MessageFactory.class));
	assertThat(
		factory.createMessage(identifiedBy("id").havingParameter("a",
			"foo").havingParameter("b", "bar")),
		is(equalTo("Message: a='foo', b='bar'")));
    }
}
