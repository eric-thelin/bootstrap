package se.ericthelin.bootstrap;

import java.util.List;

public interface MessageDescription {

    String getIdentifier();

    Object getArgument(String name);

    List<MessageArgument> getArguments();

}
