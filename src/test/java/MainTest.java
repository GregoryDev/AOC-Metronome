import org.junit.Rule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import v1.Controller.Controller;
import v1.Controller.ControllerImp;
import shared.Engine.Engine;
import shared.Engine.EngineImp;
import v1.IHM.Ihm;
import v1.IHM.IhmImp;

public class MainTest {

    Engine engine;

    @InjectMocks
    Controller controller;

    @Mock
    Ihm ihm;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    public MainTest() {
        ihm = new Mockito().mock(IhmImp.class);
        engine = new EngineImp();
        controller = new ControllerImp(engine, ihm);
    }
}
