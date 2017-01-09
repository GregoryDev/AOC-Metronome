package v2.IHM;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;

public class KeyboardImp implements Keyboard {

    private List<KeyCode> keys = new ArrayList<KeyCode>();

    @Override
    public void addKey(KeyCode e) {
        if (!keys.contains(e)) keys.add(e);
    }

    @Override
    public void removeKey(KeyCode e) {
        keys.remove(e);
    }

    @Override
    public boolean containsKey(KeyCode e) {
        return keys.contains(e);
    }
}
