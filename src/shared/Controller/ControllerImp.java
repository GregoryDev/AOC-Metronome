package shared.Controller;

import shared.Command.*;
import v1.Command.*;
import shared.Engine.Engine;
import shared.Engine.EngineEvent;
import shared.IHM.Ihm;
import shared.IHM.IhmEvent;

public class ControllerImp implements Controller {

    private Engine engine;
    private Ihm ihm;

    public ControllerImp(Engine engine, Ihm ihm){
        this.engine = engine;
        this.ihm = ihm;

        this.ihm.setCommand(IhmEvent.START, initializeCommand(new Start()));
        this.ihm.setCommand(IhmEvent.STOP, initializeCommand(new Stop()));
        this.ihm.setCommand(IhmEvent.INC, initializeCommand(new IncTime()));
        this.ihm.setCommand(IhmEvent.DEC, initializeCommand(new DecTime()));
        this.ihm.setCommand(IhmEvent.CURSOR, initializeCommand(new UpdateCursor()));

        this.engine.setCommand(EngineEvent.UPDATE_STARTED, initializeCommand(new UpdateStarted()));
        this.engine.setCommand(EngineEvent.UPDATE_TEMPO, initializeCommand(new UpdateTempo()));
        this.engine.setCommand(EngineEvent.UPDATE_TIME, initializeCommand(new UpdateTime()));
        this.engine.setCommand(EngineEvent.TEMPO, initializeCommand(new Tempo()));
        this.engine.setCommand(EngineEvent.MESURE, initializeCommand(new Mesure()));

        updateStarted();
        updateTempo();
        updateTime();
    }

    private Command initializeCommand(Command c) {
        c.setController(this);
        return c;
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
    public void tempo(){
        ihm.tempo();
    }

    @Override
    public void mesure(){
        ihm.mesure();
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
