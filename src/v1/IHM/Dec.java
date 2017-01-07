package v1.IHM;

import v1.Command.Command;

public class Dec implements Component {

    private static Dec instance = new Dec();
    private Command c;

    private Dec(){}

    public static Dec getInstance() {
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