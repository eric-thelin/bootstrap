package se.ericthelin.bootstrap;

public class MessageArgument {

    private final String name;
    private final Object value;

    public MessageArgument(String name, Object value) {
	this.name = name;
	this.value = value;
    }

    @Override
    public String toString() {
	return String.format("%s=\"%s\"", name, value);
    }

    Object getValue() {
	return value;
    }

}
