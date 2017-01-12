package v1.Controller;

public interface Controller {

    /**
     * Met a jour le tempo sur l'ihm
     */
    void updateTempo();

    /**
     * Met a jour le statut (started or not) sur l'ihm
     */
    void updateStarted();

    /**
     * Met a jour le nombre de temps sur l'ihm
     */
    void updateTime();

    /**
     * Marque un temps
     */
    void tempo();

    /**
     * Marque une mesure
     */
    void mesure();

    /**
     * Change le tempo dans le moteur
     */
    void setTempo();

    /**
     * Demarre le metronome
     */
    void start();

    /**
     * Arrete le metronome
     */
    void stop();

    /**
     * Augmente le nombre de temps
     */
    void incTime();

    /**
     * Diminue le nombre de temps
     */
    void decTime();
}
