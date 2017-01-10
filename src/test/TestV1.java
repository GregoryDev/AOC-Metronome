package test;

import shared.Controller.Controller;
import shared.Controller.ControllerImp;
import shared.Engine.Engine;
import shared.Engine.EngineImp;
import shared.IHM.Ihm;
import v1.IHM.IhmImp;

public abstract class TestV1 {

    protected Controller controller;
    protected Engine engine;
    protected Ihm ihm;

    public TestV1 () {
        engine = new EngineImp();
        ihm = new IhmImp();
        controller = new ControllerImp(engine, ihm);
    }

}
