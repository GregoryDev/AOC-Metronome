package v2.Command;

import v2.Controller.ControllerAdapter;

public abstract class CommandControllerAdapter {

    protected ControllerAdapter controller;

    /**
     * Initialisation de la cible
     * @param controller la cible de la commande
     */
    public void setController(ControllerAdapter controller) {
        this.controller = controller;
    }
}
