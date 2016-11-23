package v1.IHM;

/**
 * Created by greg on 16/11/16.
 */
public interface Ihm {

    void updateTempo(float tempo);
    void updateStarted(boolean started);
    void updateTime(int time);
    float getCursorPosition();
}

