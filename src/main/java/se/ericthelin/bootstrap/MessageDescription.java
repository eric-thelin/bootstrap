package se.ericthelin.bootstrap;

import java.util.List;

public interface MessageDescription {

    String getIdentifier();

    boolean hasArguments();

    Object getArgument(String name);

    List<MessageArgument> getArguments();

}
