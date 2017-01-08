package v1.IHM;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import v1.Command.Command;
import v1.Engine.EngineEvent;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class IhmImp implements Ihm, Initializable {

    private HashMap<IhmEvent, Component> components = new HashMap<>();

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

    @FXML
    private Text tempo;

    @FXML
    private Text mesure;

    public IhmImp(){
        components.put(IhmEvent.CURSOR, new Cursor());
        components.put(IhmEvent.DEC, new Cursor());
        components.put(IhmEvent.INC, new Cursor());
        components.put(IhmEvent.START, new Cursor());
        components.put(IhmEvent.STOP, new Cursor());
    }

    @Override
    public void setCommand(IhmEvent type, Command c) {
        components.get(type).setCommand(c);
    }

    @FXML
    protected void start(ActionEvent event) {
        components.get(IhmEvent.START).execute();
    }

    @FXML
    protected void stop(ActionEvent event) {
        components.get(IhmEvent.STOP).execute();
    }

    @FXML
    protected void inc(ActionEvent event) {
        components.get(IhmEvent.INC).execute();
    }

    @FXML
    protected void dec(ActionEvent event) {
        components.get(IhmEvent.DEC).execute();
    }

    @FXML
    protected void cursor(MouseEvent event) {
        components.get(IhmEvent.CURSOR).execute();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        disabled(true);
    }

    @Override
    public double getCursorPosition() {
        System.out.print("getCursor");
        return cursor.getValue();
    }

    @Override
    public void updateTempo(double tempo) {
        this.tempo.setText("Tempo : " + tempo);
        cursor.setValue(tempo);
    }

    @Override
    public void updateStarted(boolean started) {
        disabled(!started);
    }

    @Override
    public void updateTime(int time) {
        mesure.setText("Mesures : " + time);
    }

    private void disabled(boolean on){
        start.setDisable(!on);
        stop.setDisable(on);
        inc.setDisable(on);
        dec.setDisable(on);
        cursor.setDisable(on);
    }
}
