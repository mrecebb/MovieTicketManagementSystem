package ui.commands;

import java.io.IOException;

public interface Command {
    String commandName();
    void process() throws IOException;
}
