package v1.IHM;

import v1.Command.Command;

public class Inc implements Component {

    private static Inc instance = new Inc();
    private Command c;

    private Inc(){}

    public static Inc getInstance() {
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