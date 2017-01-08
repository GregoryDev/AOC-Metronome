package shared.Engine;

import shared.Command.Command;

public interface Engine {

    void setCommand(EngineEvent type, Command c);

    void setTempo(int t);
    void start();
    void stop();
    void incTime();
    void decTime();

    int getTempo();
    int getTime();
    boolean isStarted();

    void incCurrentTime();
}