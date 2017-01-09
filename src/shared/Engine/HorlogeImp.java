package shared.Engine;

public class HorlogeImp implements Horloge {

    private Engine engine;
    private boolean running;

    /**
     * Constructeur de l'Horloge et mise a jour du boolean running
     * @param engine
     */
    public HorlogeImp(Engine engine) {
        this.engine = engine;
        running = true;
    }

    @Override
    public void stopRunning() {
        running = false;
    }

    /**
     * Execute le thread avec une pause correspondante au tempo
     */
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
