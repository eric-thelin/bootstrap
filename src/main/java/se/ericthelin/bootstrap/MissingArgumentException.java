package se.ericthelin.bootstrap;

import static se.ericthelin.bootstrap.FluentMessageDescription.identifiedBy;
import static se.ericthelin.bootstrap.MessageUtility.createMessage;

public class MissingArgumentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MissingArgumentException(MessageDescription description,
	    String argumentName) {
	super(createMessage(identifiedBy(MissingArgumentException.class)
		.havingParameter("description", description).havingParameter(
			"argumentName", argumentName)));
    }

}
