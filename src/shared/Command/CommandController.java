package shared.Command;

import shared.Controller.Controller;

public abstract class CommandController implements Command {

    protected Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
