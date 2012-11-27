package se.ericthelin.bootstrap;

import static se.ericthelin.bootstrap.ArgumentUtility.verifyNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FluentMessageDescription implements MessageDescription {

    public static FluentMessageDescription identifiedBy(Class<?> identifier) {
	return new FluentMessageDescription(identifier);
    }

    private final Class<?> identifier;
    private final Map<String, MessageArgument> parameters = new HashMap<String, MessageArgument>();

    private FluentMessageDescription(Class<?> identifier) {
	this.identifier = verifyNotNull(identifier);
    }

    @Override
    public Class<?> getIdentifier() {
	return identifier;
    }

    @Override
    public boolean equals(Object obj) {
	MessageDescription other = (MessageDescription) obj;

	return identifier.equals(other.getIdentifier());
    }

    public FluentMessageDescription havingParameter(String name, Object value) {
	this.parameters.put(name, new MessageArgument(name, value));

	return this;
    }

    @Override
    public Object getArgument(String name) {
	if (!parameters.containsKey(name)) {
	    throw new MissingArgumentException(this, name);
	}
	return parameters.get(name).getValue();
    }

    @Override
    public Collection<MessageArgument> getArguments() {
	return Collections.unmodifiableCollection(parameters.values());
    }
}
