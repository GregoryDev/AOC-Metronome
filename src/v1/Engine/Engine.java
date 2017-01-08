package v1.Engine;

import v1.Command.Command;

public interface Engine {

    void setCommand(EngineEvent type, Command c);

    void setTempo(float t);
    void start();
    void stop();
    void incTime();
    void decTime();

    float getTempo();
    boolean isStarted();
    int getTime();
}
