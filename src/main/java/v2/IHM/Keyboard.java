package v2.IHM;

import javafx.scene.input.KeyCode;

public interface Keyboard {

    /**
     * Indique qu'une touche a ete pressee
     * @param e la touche en question
     */
    void addKey(KeyCode e);

    /**
     * Indique qu'une touche a ete relachee
     * @param e la touche en question
     */
    void removeKey(KeyCode e);

    /**
     * Verifie si une touche est en train d'etre pressee
     * @param e la touche testee
     * @return oui ou non
     */
    boolean containsKey(KeyCode e);
}
