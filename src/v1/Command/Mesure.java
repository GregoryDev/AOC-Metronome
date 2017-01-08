package v1.Command;

/**
 * Created by yoan on 08/01/17.
 */
public class Mesure extends Command {

    @Override
    public void execute() {
        controller.incTime();
    }
}
