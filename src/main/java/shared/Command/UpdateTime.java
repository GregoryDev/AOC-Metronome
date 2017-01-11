package shared.Command;

public class UpdateTime extends CommandController {

    @Override
    public void execute() {
        controller.updateTime();
    }
}
