package se.ericthelin.bootstrap;

import static se.ericthelin.bootstrap.ArgumentUtility.verifyNotNull;

public class MessageUtility {

    private static MessageFactory factory = new ClassNameMessageFactory();

    public static String createMessage(MessageDescription description) {
	return factory.createMessage(verifyNotNull(description));
    }

    public static void use(MessageFactory catalog) {
	MessageUtility.factory = verifyNotNull(catalog);
    }

    static void reset() {
	factory = new ClassNameMessageFactory();
    }
}
