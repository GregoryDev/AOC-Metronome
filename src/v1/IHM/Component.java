package v1.IHM;

import v1.Command.Command;

/**
 * Created by greg on 16/11/16.
 */
abstract class Component {

        protected Command c;

        public void setCommand(Command c) {
            this.c = c;
        }
}
