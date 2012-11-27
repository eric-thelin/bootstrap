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
    public String createMessage(Class<?> c) {
	if (!properties.containsKey(c.getName())) {
	    return delegate.createMessage(c);
	}

	return properties.getProperty(c.getName());
    }

}
