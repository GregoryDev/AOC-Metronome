package v2.Clock;

import shared.Command.Command;
import shared.Engine.Engine;

public interface Clock extends Runnable {

    /**
     * Initialise la commande a executer a chaque tour d'horloge
     * @param c la commande en question
     */
    void setCommand(Command c);
}
