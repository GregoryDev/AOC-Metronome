package v1.Engine;

import v1.Command.Command;

import java.util.HashMap;

public class EngineImp implements Engine{

    private HashMap<EngineEvent, Command> commands = new HashMap<>();

    private float tempo;
    private int time;
    private boolean started;
    private int currentTime = 0;
    private Horloge horloge;

    public EngineImp(){
        tempo = 60;
        started = false;
        time = 2;
        currentTime = 0;
        horloge = new HorlogeImp();
    }

    @Override
    public void setCommand(EngineEvent type, Command c) {
        commands.put(type, c);
    }

    @Override
    public void setTempo(float t) {
        tempo = t;
        commands.get(EngineEvent.UPDATE_TEMPO).execute();
    }

    @Override
    public void start() {
        started = true;
        commands.get(EngineEvent.UPDATE_STARTED).execute();
    }

    @Override
    public void stop() {
        started = false;
        commands.get(EngineEvent.UPDATE_STARTED).execute();
    }

    @Override
    public void incTime() {
        if(time < 7) {
            time++;
            commands.get(EngineEvent.UPDATE_TIME).execute();
        }
    }

    @Override
    public void decTime() {
        if(time > 2) {
            time--;
            commands.get(EngineEvent.UPDATE_TIME).execute();
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
