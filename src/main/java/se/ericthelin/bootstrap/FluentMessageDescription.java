package se.ericthelin.bootstrap;

import static se.ericthelin.bootstrap.ArgumentUtility.verifyNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FluentMessageDescription implements MessageDescription {

    public static FluentMessageDescription identifiedBy(Class<?> identifier) {
	return new FluentMessageDescription(verifyNotNull(identifier).getName());
    }

    public static FluentMessageDescription identifiedBy(String identifier) {
	return new FluentMessageDescription(identifier);
    }

    private final String identifier;
    private final Map<String, MessageArgument> argumentsByName = new HashMap<String, MessageArgument>();
    private final List<MessageArgument> arguments = new ArrayList<>();

    private FluentMessageDescription(String identifier) {
	this.identifier = verifyNotNull(identifier);
    }

    @Override
    public String getIdentifier() {
	return identifier;
    }

    @Override
    public boolean equals(Object obj) {
	MessageDescription other = (MessageDescription) obj;

	return identifier.equals(other.getIdentifier());
    }

    public FluentMessageDescription havingParameter(String name, Object value) {
	MessageArgument argument = new MessageArgument(name, value);
	this.argumentsByName.put(name, argument);
	this.arguments.add(argument);
	return this;
    }

    @Override
    public boolean hasArguments() {
	return !arguments.isEmpty();
    }

    @Override
    public Object getArgument(String name) {
	if (!argumentsByName.containsKey(name)) {
	    throw new MissingArgumentException(this, name);
	}
	return argumentsByName.get(name).getValue();
    }

    @Override
    public List<MessageArgument> getArguments() {
	return Collections.unmodifiableList(arguments);
    }
}
