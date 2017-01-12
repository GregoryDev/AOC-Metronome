import org.junit.*;

public class StartStopTest extends MainTest {

    /**
     * verification de la valeur initiale
     */
    @Test
    public void startInit () {
        Assert.assertFalse(engine.isStarted());
    }

    /**
     * verification du demarrage du metronome
     */
    @Test
    public void start () {
        controller.start();
        Assert.assertTrue(engine.isStarted());
    }

    /**
     * verification de l'arret du metronome
     */
    @Test
    public void stop () {
        controller.start();
        Assert.assertTrue(engine.isStarted());
        controller.stop();
        Assert.assertFalse(engine.isStarted());
    }
}
