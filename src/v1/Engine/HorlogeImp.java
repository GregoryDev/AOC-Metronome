package v1.Engine;

public class HorlogeImp implements Horloge {

    private Engine engine;
    private boolean running;

    public HorlogeImp(Engine engine) {
        this.engine = engine;
        running = true;
    }

    public void stopRunning() {
        running = false;
    }

    public void run() {
        while (running) {
            try {
                Thread.sleep((long)((double)60 / (double)engine.getTempo() * (double)1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            engine.incCurrentTime();
        }
    }
}
