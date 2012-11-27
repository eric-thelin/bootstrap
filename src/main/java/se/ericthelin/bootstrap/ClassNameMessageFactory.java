package se.ericthelin.bootstrap;

class ClassNameMessageFactory implements MessageFactory {

    @Override
    public String createMessage(MessageDescription description) {
	return messageFor(getMessagePartOf(description.getIdentifier()
		.getSimpleName()));
    }

    private String getMessagePartOf(String name) {
	return name.substring(0, name.lastIndexOf("Exception"));
    }

    private String messageFor(String name) {
	StringBuilder result = new StringBuilder();

	result.append(name.charAt(0));

	for (int i = 1; i < name.length(); i++) {
	    if (Character.isUpperCase(name.charAt(i))) {
		result.append(" ");
		result.append(Character.toLowerCase(name.charAt(i)));
	    } else {
		result.append(name.charAt(i));
	    }
	}

	return result.toString();
    }
}
