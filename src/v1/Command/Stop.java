package v1.Command;

public class Stop extends Command{

    @Override
    public void execute() {
        controller.stop();
    }
}
