package se.ericthelin.bootstrap;

public class ParameterMappingMessageFactory implements MessageFactory {

    @Override
    public String createMessage(MessageDescription description) {
	if (!description.hasArguments()) {
	    return description.getIdentifier();
	}
	StringBuilder builder = new StringBuilder(description.getIdentifier());
	builder.append(": ");

	boolean tail = false;
	for (MessageArgument argument : description.getArguments()) {
	    if (tail) {
		builder.append(", ");
	    }

	    builder.append(argument);

	    tail = true;
	}

	return builder.toString();
    }
}
