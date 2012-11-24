package se.ericthelin.bootstrap;

import static se.ericthelin.bootstrap.ArgumentUtility.verifyNotNull;

public class MessageUtility {

    private static MessageCatalog catalog = new ClassNameMessageCatalog();

    public static String messageFor(Class<?> c) {
	return catalog.messageFor(verifyNotNull(c));
    }

    public static void use(MessageCatalog catalog) {
	MessageUtility.catalog = verifyNotNull(catalog);
    }

    static void reset() {
	catalog = new ClassNameMessageCatalog();
    }
}
