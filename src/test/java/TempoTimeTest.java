import org.junit.*;
import org.mockito.Mockito;

public class TempoTimeTest extends MainTest {

    @Before
    public void before () {
        engine.start();
    }

    @After
    public void after () {
        engine.stop();
    }

    /**
     * verification de la valeur initiale du tempo
     */
    @Test
    public void tempoInit () {
        Assert.assertEquals(engine.getTempo(), 60);
    }

    /**
     * on verifie la modification du tempo
     */
    @Test
    public void changeTempo () {
        Mockito.when(ihm.getCursorPosition()).thenReturn(100.0);
        controller.setTempo();
        Assert.assertEquals(engine.getTempo(), 100);
    }

    /**
     * on verifie qu'on ne peut pas set
     * un tempo superieur a 300
     */
    @Test
    public void tempoMax () {
        Mockito.when(ihm.getCursorPosition()).thenReturn(400.0);
        controller.setTempo();
        Assert.assertEquals(engine.getTempo(), 300);
    }

    /**
     * on verifie qu'on ne peut pas set
     * un tempo superieur a 300
     */
    @Test
    public void tempoMin () {
        Mockito.when(ihm.getCursorPosition()).thenReturn(5.0);
        controller.setTempo();
        Assert.assertEquals(engine.getTempo(), 10);
    }

    /**
     * verification de la valeur initiale du temps
     */
    @Test
    public void timeInit () {
        Assert.assertEquals(engine.getTime(), 2);
    }

    /**
     * verification de l'incrementation du nombre de temps
     */
    @Test
    public void timeInc () {
        controller.incTime();
        Assert.assertEquals(engine.getTime(), 3);
    }

    /**
     * verification de la decrementation du nombre de temps
     */
    @Test
    public void timeDec () {
        controller.decTime();
        Assert.assertEquals(engine.getTime(), 2);
    }

    /**
     * verification de la valeur maximale du temps (7)
     */
    @Test
    public void timeMax () {
        controller.incTime();
        controller.incTime();
        controller.incTime();
        controller.incTime();
        controller.incTime();
        Assert.assertEquals(engine.getTime(), 7);
    }

    /**
     * verification de la valeur minimale du temps (2)
     */
    @Test
    public void timeMin () {
        controller.decTime();
        controller.decTime();
        controller.decTime();
        controller.decTime();
        controller.decTime();
        controller.decTime();
        Assert.assertEquals(engine.getTime(), 2);
    }
}
