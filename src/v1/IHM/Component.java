package v1.IHM;

import v1.Command.Command;

public interface Component {

        void setCommand(Command c);
        void execute();
}
