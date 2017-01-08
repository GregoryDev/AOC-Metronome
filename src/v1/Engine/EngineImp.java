package v1.Engine;

import v1.Command.Command;

import java.util.HashMap;

public class EngineImp implements Engine{

    private HashMap<EngineEvent, Command> commands = new HashMap<>();

    private int tempo;
    private int time;
    private int currentTime = 0;
    private Horloge horloge;

    public EngineImp(){
        horloge = new HorlogeImp();
        horloge.setEngine(this);
        tempo = 60;
        time = 2;
        currentTime = 0;
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
        horloge.startHorloge();
        commands.get(EngineEvent.UPDATE_STARTED).execute();
    }

    @Override
    public void stop() {
        horloge.stopHorloge();
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
        if (currentTime == time) {
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
        return horloge.isStarted();
    }

    @Override
    public int getTime(){
        return time;
    }


}
