package shared.Command;

public class Mesure extends Command {

    @Override
    public void execute() {
        controller.mesure();
    }
}
