package v1.IHM;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import v1.Command.Command;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class IhmImp implements Ihm, Initializable {

    private HashMap<IhmEvent, Command> commands = new HashMap<>();
    private Bipeur bipeur;

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

    @FXML
    private CheckBox tempoLed;

    @FXML
    private CheckBox mesureLed;

    @Override
    public void setCommand(IhmEvent type, Command c) {
        commands.put(type, c);
    }

    @FXML
    protected void start(ActionEvent event) {
        commands.get(IhmEvent.START).execute();
    }

    @FXML
    protected void stop(ActionEvent event) {
        commands.get(IhmEvent.STOP).execute();
    }

    @FXML
    protected void inc(ActionEvent event) {
        commands.get(IhmEvent.INC).execute();
    }

    @FXML
    protected void dec(ActionEvent event) {
        commands.get(IhmEvent.DEC).execute();
    }

    @FXML
    protected void cursor(MouseEvent event) {
        commands.get(IhmEvent.CURSOR).execute();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bipeur = new BipeurImp();
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

    @Override
    public void tempo() {
        tempoLed.setSelected(true);
        bipeur.playTempo();
        tempoLed.setSelected(false);
    }

    @Override
    public void mesure() {
        mesureLed.setSelected(true);
        bipeur.playMesure();
        mesureLed.setSelected(false);
    }

    private void disabled(boolean on){
        start.setDisable(!on);
        stop.setDisable(on);
        inc.setDisable(on);
        dec.setDisable(on);
        cursor.setDisable(on);
    }
}
