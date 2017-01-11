package shared.Command;

public class Stop extends CommandController {

    @Override
    public void execute() {
        controller.stop();
    }
}
