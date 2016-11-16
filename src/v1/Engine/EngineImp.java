package v1.Engine;

import v1.Command.Command;

import java.util.HashMap;

/**
 * Created by greg on 07/11/16.
 */
public class EngineImp implements Engine{

    private HashMap<TypeEvent, Command> commands = new HashMap<>();

    private float tempo;

    public void EngineImp(float tempo){
        this.tempo = tempo;
    }

    @Override
    public void setCommand(TypeEvent type, Command c) {
        commands.put(type, c);
    }

    @Override
    public void setTempo(float t) {
        tempo = t;
        commands.get(TypeEvent.UPDATE_TEMPO).execute();
    }
}
