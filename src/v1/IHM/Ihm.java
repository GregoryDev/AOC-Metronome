package v1.IHM;

import v1.Command.Command;

public interface Ihm {

    void updateTempo(double tempo);
    void updateStarted(boolean started);
    void updateTime(int time);
    double getCursorPosition();

    void setStartCommand(Command start);
    void setStopCommand(Command stop);
    void setIncCommand(Command inc);
    void setDecCommand(Command dec);
    void setCursorCommand(Command updateCursor);
}

