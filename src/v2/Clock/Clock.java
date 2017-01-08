package v2.Clock;

import shared.Command.Command;
import shared.Engine.Engine;

public interface Clock extends Runnable {

    void setCommand(Command c);
}
