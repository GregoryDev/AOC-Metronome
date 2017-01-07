package v1.Controller;

public interface Controller {

    void updateTempo();
    void updateStarted();
    void updateTime();

    void setTempo();
    void start();
    void stop();
    void incTime();
    void decTime();
}
