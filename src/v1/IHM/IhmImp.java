package v1.IHM;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import v1.Command.Command;

import java.net.URL;
import java.util.ResourceBundle;

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

    @FXML
    private Text tempo;

    @FXML
    private Text mesure;

    public IhmImp(){
        cursorCom = Cursor.getInstance();
        decCom = Dec.getInstance();
        incCom = Inc.getInstance();
        startCom = new Start();//Start.getInstance();
        stopCom = Stop.getInstance();
    }

    @Override
    public void setStartCommand(Command start){
        startCom.setCommand(start);
    }

    @Override
    public void setStopCommand(Command stop) {
        stopCom.setCommand(stop);
    }

    @Override
    public void setIncCommand(Command inc) {
        incCom.setCommand(inc);
    }

    @Override
    public void setDecCommand(Command dec) {
        decCom.setCommand(dec);
    }

    @Override
    public void setCursorCommand(Command updateCursor) {
        cursorCom.setCommand(updateCursor);
    }

    @FXML
    protected void start(ActionEvent event) {
        startCom.execute();
    }

    @FXML
    protected void stop(ActionEvent event) {
        stopCom.execute();
    }

    @FXML
    protected void inc(ActionEvent event) {
        incCom.execute();
    }

    @FXML
    protected void dec(ActionEvent event) {
        decCom.execute();
    }

    @FXML
    protected void cursor(MouseEvent event) {
        cursorCom.execute();
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
