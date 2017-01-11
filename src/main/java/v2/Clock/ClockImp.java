package v2.Clock;

import shared.Command.Command;
import shared.Engine.Engine;

public class ClockImp implements Clock {

    Command c;

    @Override
    public void setCommand(Command c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.execute();
        }
    }
}
