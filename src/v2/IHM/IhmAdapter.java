package v2.IHM;

import shared.Command.Command;
import shared.IHM.Ihm;
import shared.IHM.IhmEvent;

public class IhmAdapter implements Ihm {

    @Override
    public void updateTempo(double tempo) {

    }

    @Override
    public void updateStarted(boolean started) {

    }

    @Override
    public void updateTime(int time) {

    }

    @Override
    public double getCursorPosition() {
        return 0;
    }

    @Override
    public void tempo() {

    }

    @Override
    public void mesure() {

    }

    @Override
    public void switchLed(String type) {

    }

    @Override
    public void setCommand(IhmEvent type, Command c) {

    }
}
