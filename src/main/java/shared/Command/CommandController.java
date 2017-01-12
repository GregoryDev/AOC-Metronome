package shared.Command;

import v1.Controller.Controller;

public abstract class CommandController implements Command {

    protected Controller controller;

    /**
     * Associe le controleur a la commande
     * @param controller
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
