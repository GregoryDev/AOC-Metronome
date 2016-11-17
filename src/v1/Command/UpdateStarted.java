package v1.Command;

import v1.Controller.Controller;

/**
 * Created by greg on 16/11/16.
 */
public class UpdateStarted implements Command {

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.updateStarted();
    }
}
