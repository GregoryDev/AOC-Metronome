package v2.Controller;

import v1.Controller.ControllerImp;
import shared.Engine.Engine;
import v1.IHM.Ihm;
import v2.IHM.IhmAdapter;

public class ControllerAdapterImp extends ControllerImp implements ControllerAdapter {

    private IhmAdapter ihm;

    /**
     * Constructeur du controller
     * @param engine le moteur du metronome
     * @param ihm l'interface de l'ihm (Adapter)
     */
    public ControllerAdapterImp(Engine engine, Ihm ihm) {
        super(engine, ihm);
        this.ihm = (IhmAdapter)ihm;
    }

    @Override
    public void read() {
        ihm.read();
    }
}
