package v2.IHM;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import shared.Command.Command;
import shared.IHM.Bipeur;
import shared.IHM.BipeurImp;
import v1.IHM.IhmEvent;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class IhmAdapterImp implements IhmAdapter, Initializable {

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

        keysCommands.put(KeyCode.P, IhmEvent.INC);
        keysCommands.put(KeyCode.M, IhmEvent.DEC);
        keysCommands.put(KeyCode.SPACE, IhmEvent.START);
        keysCommands.put(KeyCode.BACK_SPACE, IhmEvent.STOP);
        keysCommands.put(KeyCode.O, IhmEvent.CURSOR);
        keysCommands.put(KeyCode.L, IhmEvent.CURSOR);

        keysStates.put(KeyCode.P, false);
        keysStates.put(KeyCode.M, false);
        keysStates.put(KeyCode.SPACE, false);
        keysStates.put(KeyCode.BACK_SPACE, false);
        keysStates.put(KeyCode.O, false);
        keysStates.put(KeyCode.L, false);
    }

    @Override
    public double getCursorPosition() {
        return cursorValue;
    }

    @Override
    public void updateTempo(double tempo) {
        this.tempo.setText("Tempo : " + (int)tempo + " bpm");
        cursorValue = tempo;
    }

    @Override
    public void updateStarted(boolean started) {
        this.started.setText("Started : " + started);
    }

    @Override
    public void updateTime(int time) {
        mesure.setText("Mesure : " + time + " temps");
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

    @Override
    public void read() {
        for (KeyCode key : keysStates.keySet()) {
            if (keysStates.get(key) && !keyboard.containsKey(key)) {
                updateCursor(key);
                commands.get(keysCommands.get(key)).execute();
            }
            keysStates.put(key, keyboard.containsKey(key));
        }
    }

    /**
     * Met jour la valeur de tempo de notre ihm
     * @param key determine si on augmente ou dimininue le tempo
     */
    private void updateCursor(KeyCode key) {
        if (key == KeyCode.O) cursorValue = Math.min(300, cursorValue + 10);
        if (key == KeyCode.L) cursorValue = Math.max(10, cursorValue - 10);
    }
}
