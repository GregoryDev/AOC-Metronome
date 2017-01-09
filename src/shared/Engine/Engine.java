package shared.Engine;

import shared.Command.Command;

public interface Engine {

    /**
     * Associe une commande avec un evenement
     * @param type
     * @param c
     */
    void setCommand(EngineEvent type, Command c);

    /**
     * Met a jour la variable interne tempo du moteur, puis execute la commande associee
     * @param t
     */
    void setTempo(int t);

    /**
     * Met a jour la variable interne started et instancie une Horloge, puis execute la commande associee
     */
    void start();

    /**
     * Met a jour la variable interne started et stoppe l'Horloge, puis execute la commande associee
     */
    void stop();

    /**
     * Incremente la variable interne time si elle est inferieur a 7, puis execute la commande associee
     */
    void incTime();

    /**
     * Decremente la variable interne time si elle est superieur a 2, puis execute la commande associee
     */
    void decTime();

    /**
     * Retourne la valeur du tempo
     * @return
     */
    int getTempo();

    /**
     * Retourne la valeur de time
     * @return
     */
    int getTime();

    /**
     * Retourne le boolean started
     * @return
     */
    boolean isStarted();

    /**
     * Met a jour la valeur courante de la mesure, puis execute la commande correspondante
     */
    void incCurrentTime();
}
