package shared.Command;

public class UpdateTempo extends CommandController {

    @Override
    public void execute() {
        controller.updateTempo();
    }
}
