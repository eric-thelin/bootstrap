package se.ericthelin.bootstrap;

public final class ArgumentUtility {

    public static <T> T verifyNotNull(T argument) {
	if (argument == null) {
	    throw new NullArgumentException();
	}

	return argument;
    }
}
