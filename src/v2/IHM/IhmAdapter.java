package v2.IHM;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import shared.Command.Command;
import shared.IHM.Bipeur;
import shared.IHM.BipeurImp;
import shared.IHM.Ihm;
import shared.IHM.IhmEvent;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class IhmAdapter implements Ihm, Initializable {

    private HashMap<IhmEvent, Command> commands = new HashMap<>();
    private Bipeur bipeur;

    private double cursorValue;

    @FXML
    private Text tempo;

    @FXML
    private Text mesure;

    @FXML
    private Text started;

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
        bipeur = new BipeurImp(this);
    }

    @Override
    public double getCursorPosition() {
        return cursorValue;
    }

    @Override
    public void updateTempo(double tempo) {
        this.tempo.setText("Tempo : " + (int)tempo);
        cursorValue = tempo;
    }

    @Override
    public void updateStarted(boolean started) {
        this.started.setText("Started : " + started);
    }

    @Override
    public void updateTime(int time) {
        mesure.setText("Mesures : " + time);
    }

    @Override
    public void tempo() {
        bipeur.playTempo();
    }

    @Override
    public void mesure() {
        bipeur.playMesure();
    }

    @Override
    public void switchLed(String type) {
        if (type == "tempo") tempoLed.setSelected(!tempoLed.isSelected());
        else mesureLed.setSelected(!mesureLed.isSelected());
    }
}
