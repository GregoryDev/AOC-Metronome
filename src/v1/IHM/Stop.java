package v1.IHM;

import v1.Command.Command;

public class Stop implements Component {

    private static Stop instance = new Stop();
    private Command c;

    private Stop(){}

    public static Stop getInstance() {
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