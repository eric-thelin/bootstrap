package se.ericthelin.bootstrap;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesMessageFactory implements MessageFactory {

    static final Pattern PLACEHOLDER_PATTERN = Pattern
	    .compile("\\$\\{(\\w+)\\}");

    private final Properties properties;
    private final MessageFactory delegate;

    public PropertiesMessageFactory(Properties properties,
	    MessageFactory delegate) {
	this.properties = properties;
	this.delegate = delegate;
    }

    @Override
    public String createMessage(MessageDescription description) {
	if (!properties.containsKey(description.getIdentifier().getName())) {
	    return delegate.createMessage(description);
	}

	String messageTemplate = properties.getProperty(description
		.getIdentifier().getName());

	return replaceParameters(messageTemplate, description);
    }

    private String replaceParameters(String template,
	    MessageDescription description) {

	Matcher matcher = PLACEHOLDER_PATTERN.matcher(template);

	String result = template;

	while (matcher.find()) {
	    String placeholder = matcher.group();
	    String name = matcher.group(1);

	    result = result.replace(placeholder, description.getArgument(name)
		    .toString());
	}

	return result;
    }
}
