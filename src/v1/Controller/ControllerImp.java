package v1.Controller;

import v1.Command.*;
import v1.Engine.Engine;
import v1.Engine.TypeEvent;
import v1.IHM.Ihm;

public class ControllerImp implements Controller {

    private Engine engine;
    private Ihm ihm;

    public ControllerImp(Engine engine, Ihm ihm){
        this.engine = engine;
        this.ihm = ihm;

        Command start = new Start();
        start.setController(this);
        this.ihm.setStartCommand(start);

        Command stop = new Stop();
        stop.setController(this);
        this.ihm.setStopCommand(stop);

        Command inc = new IncTime();
        inc.setController(this);
        this.ihm.setIncCommand(inc);

        Command dec = new DecTime();
        dec.setController(this);
        this.ihm.setDecCommand(dec);

        Command cursor = new UpdateCursor();
        cursor.setController(this);
        this.ihm.setCursorCommand(cursor);

        Command updateStarted = new UpdateStarted();
        updateStarted.setController(this);
        this.engine.setCommand(TypeEvent.UPDATE_STARTED, updateStarted);

        Command updateTime = new UpdateTime();
        updateTime.setController(this);
        this.engine.setCommand(TypeEvent.UPDATE_TIME, updateTime);

        Command updateTempo = new UpdateTempo();
        updateTempo.setController(this);
        this.engine.setCommand(TypeEvent.UPDATE_TEMPO, updateTempo);
    }

    @Override
    public void updateTempo() {
        ihm.updateTempo(engine.getTempo());
    }

    @Override
    public void updateStarted() {
        ihm.updateStarted(engine.isStarted());
    }

    @Override
    public void updateTime(){
        ihm.updateTime(engine.getTime());
    }

    @Override
    public void setTempo() {
        engine.setTempo((int)ihm.getCursorPosition());
    }

    @Override
    public void start() {
        engine.start();
    }

    @Override
    public void stop() {
        engine.stop();
    }

    @Override
    public void incTime() {
        engine.incTime();
    }

    @Override
    public void decTime() {
        engine.decTime();
    }


}
