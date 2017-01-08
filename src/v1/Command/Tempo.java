package v1.Command;

public class Tempo extends Command {

    @Override
    public void execute() {
        controller.tempo();
    }
}
