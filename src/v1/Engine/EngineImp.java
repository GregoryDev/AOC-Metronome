package v1.Engine;

import v1.Command.Command;

import java.util.HashMap;

public class EngineImp implements Engine{

    private HashMap<TypeEvent, Command> commands = new HashMap<>();

    private float tempo;
    private int time;
    private boolean started;

    public EngineImp(){
        tempo = 0;
        started = false;
        time = 0;
    }

    @Override
    public void setCommand(TypeEvent type, Command c) {
        commands.put(type, c);
    }

    @Override
    public void setTempo(float t) {
        if (isStarted()) {
            tempo = t;
            commands.get(TypeEvent.UPDATE_TEMPO).execute();
        }
    }

    @Override
    public void start() {
        started = true;
        commands.get(TypeEvent.UPDATE_STARTED).execute();
    }

    @Override
    public void stop() {
        started = false;
        commands.get(TypeEvent.UPDATE_STARTED).execute();
    }

    @Override
    public void incTime() {
        if(isStarted()) {
            time++;
            commands.get(TypeEvent.UPDATE_TIME).execute();
        }
    }

    @Override
    public void decTime() {
        if(isStarted()) {
            time--;
            commands.get(TypeEvent.UPDATE_TIME).execute();
        }
    }

    @Override
    public float getTempo() {
        return tempo;
    }

    @Override
    public boolean isStarted() {
        return started;
    }

    @Override
    public int getTime(){
        return time;
    }


}
