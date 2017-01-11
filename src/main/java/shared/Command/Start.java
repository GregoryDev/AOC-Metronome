package shared.Command;

public class Start extends CommandController {

    @Override
    public void execute() {
        controller.start();
    }
}
