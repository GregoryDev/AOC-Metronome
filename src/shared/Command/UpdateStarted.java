package shared.Command;

public class UpdateStarted extends Command {

    @Override
    public void execute() {
        controller.updateStarted();
    }
}
