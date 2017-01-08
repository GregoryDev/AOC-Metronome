package v1.IHM;

import v1.Command.Command;

abstract class Component {

        private Command c;

        public void setCommand(Command c) {
                this.c = c;
        }

        public void execute() {
                c.execute();
        }
}
