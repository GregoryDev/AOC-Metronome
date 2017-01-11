package shared.IHM;

import shared.Command.Command;

public interface Ihm {

    /**
     * Met a jour le tempo sur l'ihm
     * @param tempo le nouveau tempo
     */
    void updateTempo(double tempo);

    /**
     * Met a jour le statut (started or not) sur l'ihm
     * @param started le statut de demarrage
     */
    void updateStarted(boolean started);

    /**
     * Met a jour le nombre de temps sur l'ihm
     * @param time le nouveau nombre de temps
     */
    void updateTime(int time);

    /**
     * Recupere le tempo
     * @return la valeur du tempo
     */
    double getCursorPosition();

    /**
     * Marque un temps
     */
    void tempo();

    /**
     * Marque une mesure
     */
    void mesure();

    /**
     * Allume ou eteind une led
     * @param type identifie la led ("tempo" ou "mesure")
     */
    void switchLed(String type);

    /**
     * Enregistre une commande et la lie a un event
     * @param type l'event a lier
     * @param c la commande a lier
     */
    void setCommand(IhmEvent type, Command c);

}

