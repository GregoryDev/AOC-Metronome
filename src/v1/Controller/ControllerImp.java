package v1.Controller;

import v1.Engine.Engine;
import v1.IHM.Ihm;

public class ControllerImp implements Controller {

    private Engine engine;
    private Ihm ihm;

    public ControllerImp(Engine engine, Ihm ihm){
        this.engine = engine;
        this.ihm = ihm;
    }

    @Override
    public void setTempo() {
        engine.setTempo(ihm.getCursorPosition());
    }

    @Override
    public void updateTempo() { ihm.updateTempo(engine.getTempo()); }

    @Override
    public void updateStarted() {
        ihm.updateStarted(engine.isStarted());
    }

    @Override
    public void updateTime(){
        ihm.updateTime(engine.getTime());
    }
}
