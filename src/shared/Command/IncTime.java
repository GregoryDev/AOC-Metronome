package shared.Command;

public class IncTime extends Command {

    @Override
    public void execute() {
        controller.incTime();
    }
}
