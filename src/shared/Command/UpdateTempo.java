package shared.Command;

public class UpdateTempo extends Command {

    @Override
    public void execute() {
        controller.updateTempo();
    }
}
