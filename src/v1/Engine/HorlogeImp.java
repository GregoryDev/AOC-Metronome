package v1.Engine;

public class HorlogeImp extends Thread implements Horloge {

    private Engine engine;
    private boolean started;
    private boolean running;

    public HorlogeImp() {
        started = false;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void startHorloge() {
        started = true;
        start();
    }

    public void stopHorloge() {
        started = false;
    }

    public boolean isStarted() {
        return started;
    }

    public void run() {
        while (started) {
            try {
                sleep(1000/*(Long.getLong(Double.toString(engine.getTempo()/60*1000)))*/);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            engine.incCurrentTime();
        }
    }
}
