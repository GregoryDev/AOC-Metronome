package v1.Command;

public class UpdateTime extends Command {

    @Override
    public void execute() {
        controller.updateTime();
    }
}
