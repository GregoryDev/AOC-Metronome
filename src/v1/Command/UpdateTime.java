package v1.Command;

import v1.Controller.Controller;

/**
 * Created by greg on 17/11/16.
 */
public class UpdateTime implements Command {

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.updateTime();
    }
}
