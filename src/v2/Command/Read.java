package v2.Command;

import shared.Command.Command;

public class Read extends CommandAdapter implements Command {

    public void execute() {
        adapter.read();
    }
}
