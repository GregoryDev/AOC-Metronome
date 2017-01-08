package shared.Command;

public class Start extends Command {

    @Override
    public void execute() {
        controller.start();
    }
}
