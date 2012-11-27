package se.ericthelin.bootstrap;

import static se.ericthelin.bootstrap.ArgumentUtility.verifyNotNull;

public class FluentMessageDescription implements MessageDescription {

    public static FluentMessageDescription identifiedBy(Class<?> identifier) {
	return new FluentMessageDescription(identifier);
    }

    private final Class<?> identifier;

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
}
