package v1.Controller;

import v1.Engine.Engine;
import v1.IHM.Ihm;

public class ControllerImp implements Controller {

    private Engine engine;
    private Ihm ihm;

    @Override
    public void updateTempo() {
        engine.setTempo(ihm.getPosition());
    }
}
