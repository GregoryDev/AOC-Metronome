package v2.IHM;

import javafx.scene.input.KeyCode;

public interface Keyboard {

    void addKey(KeyCode e);
    void removeKey(KeyCode e);
    boolean containsKey(KeyCode e);
}
