package v1.IHM;

import v1.Command.Command;

public class Start implements Component {

    private static Start instance = new Start();
    private Command c;

    private Start(){}

    public static Start getInstance() {
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
