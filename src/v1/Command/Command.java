package v1.Command;

import v1.Controller.Controller;

/**
 * Created by greg on 07/11/16.
 */
public interface Command {

    void setController(Controller controller);
    void execute();
}
