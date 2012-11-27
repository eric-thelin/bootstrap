package se.ericthelin.bootstrap;

import java.util.Collection;

public interface MessageDescription {

    String getIdentifier();

    Object getArgument(String name);

    Collection<MessageArgument> getArguments();

}
