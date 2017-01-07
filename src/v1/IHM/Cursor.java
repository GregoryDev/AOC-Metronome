package v1.IHM;

import v1.Command.Command;

public class Cursor implements Component {

    private static Cursor instance = new Cursor();
    private Command c;

    private Cursor(){}

    public static Cursor getInstance() {
        return instance;
    }

    @Override
    public void setCommand(Command c) {
        this.c = c;
    }

    @Override
    public void execute() {
        c.execute();
    }

}
