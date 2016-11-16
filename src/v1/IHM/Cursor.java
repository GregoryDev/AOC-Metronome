package v1.IHM;

import v1.Command.Command;

/**
 * Created by greg on 16/11/16.
 */
public class Cursor implements Component {

    private Command c;

    @Override
    public void setCommand(Command c) {
        this.c = c;
    }

}
