package v2.IHM;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import shared.Command.Command;
import shared.IHM.Bipeur;
import shared.IHM.BipeurImp;
import shared.IHM.Ihm;
import shared.IHM.IhmEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class IhmAdapter implements Ihm, Initializable {

    private HashMap<IhmEvent, Command> commands = new HashMap<>();
    private HashMap<KeyCode, IhmEvent> keysCommands = new HashMap<>();
    private HashMap<KeyCode, Boolean> keysStates = new HashMap<>();
    private Bipeur bipeur;
    private Keyboard keyboard;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bipeur = new BipeurImp(this);
        keyboard = new KeyboardImp();

        keysCommands.put(KeyCode.PLUS, IhmEvent.INC);
        keysCommands.put(KeyCode.MINUS, IhmEvent.DEC);
        keysCommands.put(KeyCode.SPACE, IhmEvent.START);
        keysCommands.put(KeyCode.BACK_SPACE, IhmEvent.STOP);
        keysCommands.put(KeyCode.DOLLAR, IhmEvent.CURSOR);
        keysCommands.put(KeyCode.CIRCUMFLEX, IhmEvent.CURSOR);

        keysStates.put(KeyCode.PLUS, false);
        keysStates.put(KeyCode.MINUS, false);
        keysStates.put(KeyCode.SPACE, false);
        keysStates.put(KeyCode.BACK_SPACE, false);
        keysStates.put(KeyCode.DOLLAR, false);
        keysStates.put(KeyCode.CIRCUMFLEX, false);
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

    @FXML
    private void keyPressed(KeyEvent e) {
        keyboard.addKey(e.getCode());
    }

    @FXML
    private void keyReleased(KeyEvent e) {
        keyboard.removeKey(e.getCode());
    }

    public void lire() {
        for (KeyCode key : keysStates.keySet()) {
            if (keysStates.get(key) && !keyboard.containsKey(key))
                commands.get(keysCommands.get(key)).execute();
            keysStates.put(key, keyboard.containsKey(key));
        }
    }
}
