package se.ericthelin.bootstrap;

import java.util.Properties;

public class PropertiesMessageFactory implements MessageFactory {

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

	return properties.getProperty(description.getIdentifier().getName());
    }

}
