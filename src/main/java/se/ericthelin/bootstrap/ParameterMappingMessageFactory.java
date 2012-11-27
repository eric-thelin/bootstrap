package se.ericthelin.bootstrap;

public class ParameterMappingMessageFactory implements MessageFactory {

    @Override
    public String createMessage(MessageDescription description) {
	if (!description.hasArguments()) {
	    return "<no arguments>";
	}
	StringBuilder builder = new StringBuilder();

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
