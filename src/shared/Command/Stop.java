package shared.Command;

public class Stop extends Command{

    @Override
    public void execute() {
        controller.stop();
    }
}
