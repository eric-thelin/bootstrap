package se.ericthelin.bootstrap;

import java.util.Collection;

public interface MessageDescription {

    Class<?> getIdentifier();

    Object getArgument(String name);

    Collection<MessageArgument> getArguments();

}
