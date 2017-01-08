package shared.Command;

public class UpdateStarted extends CommandController {

    @Override
    public void execute() {
        controller.updateStarted();
    }
}
