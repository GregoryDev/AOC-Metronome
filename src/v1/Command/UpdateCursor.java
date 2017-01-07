package v1.Command;

public class UpdateCursor extends Command {

    @Override
    public void execute() {
        controller.setTempo();
    }
}
