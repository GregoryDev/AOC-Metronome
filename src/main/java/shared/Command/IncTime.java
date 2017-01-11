package shared.Command;

public class IncTime extends CommandController {

    @Override
    public void execute() {
        controller.incTime();
    }
}
