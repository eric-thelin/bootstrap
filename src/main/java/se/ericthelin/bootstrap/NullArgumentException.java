package se.ericthelin.bootstrap;

import static se.ericthelin.bootstrap.MessageUtility.messageFor;

class NullArgumentException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public NullArgumentException() {
	super(messageFor(NullArgumentException.class));
    }
}
