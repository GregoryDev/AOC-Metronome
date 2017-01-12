package v2.Command;

import shared.Command.Command;

public class Read extends CommandControllerAdapter implements Command {

    @Override
    public void execute() {
        controller.read();
    }
}
