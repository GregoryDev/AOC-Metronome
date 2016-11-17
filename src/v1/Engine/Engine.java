package v1.Engine;

import v1.Command.Command;

/**
 * Created by greg on 07/11/16.
 */
public interface Engine {

    void setCommand(TypeEvent type, Command c);
    void setTempo(float t);
    void start();
    void stop();
    void IncTime();
    void DecTime();

    float getTempo();
    boolean isStarted();
    int getTime();
}
