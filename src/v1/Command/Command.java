package v1.Command;

import v1.Controller.Controller;

public abstract class Command {

    protected Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public abstract void execute();
}
