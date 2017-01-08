package shared.Command;

import shared.Controller.Controller;

public abstract class Command {

    protected Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public abstract void execute();
}
