package se.ericthelin.bootstrap;

import static se.ericthelin.bootstrap.MessageUtility.createMessage;

class NullArgumentException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public NullArgumentException() {
	super(createMessage(NullArgumentException.class));
    }
}
