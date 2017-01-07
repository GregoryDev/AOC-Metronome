package v1.Command;

public class UpdateStarted extends Command {

    @Override
    public void execute() {
        controller.updateStarted();
    }
}
