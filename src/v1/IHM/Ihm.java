package v1.IHM;

import v1.Command.Command;

public interface Ihm {

    void updateTempo(double tempo);
    void updateStarted(boolean started);
    void updateTime(int time);
    double getCursorPosition();
    void tempo();
    void mesure();
    void switchLed(String type);

    void setCommand(IhmEvent type, Command c);

}

