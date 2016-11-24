package v1.IHM;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by greg on 23/11/16.
 */
public class IhmImp implements Ihm, Initializable {

    private Cursor cursorCom;
    private Dec decCom;
    private Inc incCom;
    private Start startCom;
    private Stop stopCom;

    @FXML
    private Slider cursor;

    @FXML
    private Button dec;

    @FXML
    private Button inc;

    @FXML
    private Button start;

    @FXML
    private Button stop;

    public IhmImp(){
        cursorCom = new Cursor();
        decCom = new Dec();
        incCom = new Inc();
        startCom = new Start();
        stopCom = new Stop();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cursor.valueProperty().addListener((observable, oldValue, newValue) -> {
            cursorCom.execute();
        });
        dec.setOnAction((event) -> {
            decCom.execute();
        });
        inc.setOnAction((event) -> {
            incCom.execute();
        });
        start.setOnAction((event) -> {
            startCom.execute();
        });
        stop.setOnAction((event) -> {
            stopCom.execute();
        });
    }

    @Override
    public float getCursorPosition(){
        return (float) cursor.getValue();
    }

    @Override
    public void updateTempo(float tempo) {
        cursor.setValue(tempo);
    }

    @Override
    public void updateStarted(boolean started) {

    }

    @Override
    public void updateTime(int time) {

    }
}
