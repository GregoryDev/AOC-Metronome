package v1.Command;

public class Start extends Command {

    @Override
    public void execute() {
        controller.start();
    }
}
