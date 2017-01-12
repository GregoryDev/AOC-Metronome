package v2.Controller;

import v1.Controller.Controller;

public interface ControllerAdapter extends Controller {

    /**
     * Lance une lecture passive du clavier
     */
    void read();
}
