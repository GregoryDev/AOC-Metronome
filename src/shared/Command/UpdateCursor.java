package shared.Command;

public class UpdateCursor extends CommandController {

    @Override
    public void execute() {
        controller.setTempo();
    }
}
