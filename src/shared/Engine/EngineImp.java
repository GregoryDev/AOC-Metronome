package shared.Engine;

import shared.Command.Command;

import java.util.HashMap;

public class EngineImp implements Engine{

    private HashMap<EngineEvent, Command> commands = new HashMap<>();

    private int tempo;
    private int time;
    private int currentTime;
    private boolean started;
    private Horloge horloge;

    public EngineImp(){
        tempo = 60;
        time = 2;
        currentTime = 0;
        started = false;
    }

    @Override
    public void setCommand(EngineEvent type, Command c) {
        commands.put(type, c);
    }

    @Override
    public void setTempo(int t) {
        tempo = t;
        commands.get(EngineEvent.UPDATE_TEMPO).execute();
    }

    @Override
    public void start() {
        if (!started) {
            started = true;
            currentTime = 0;
            horloge = new HorlogeImp(this);
            new Thread(horloge).start();
            commands.get(EngineEvent.UPDATE_STARTED).execute();
        }
    }

    @Override
    public void stop() {
        started = false;
        horloge.stopRunning();
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
    public void incCurrentTime() {
        currentTime++;
        if (currentTime >= time) {
            currentTime = 0;
            commands.get(EngineEvent.MESURE).execute();
        }
        else commands.get(EngineEvent.TEMPO).execute();
    }

    @Override
    public int getTempo() {
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
