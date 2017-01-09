package shared.Controller;

public interface Controller {

    /**
     * Mets a jour le tempo sur l'ihm
     */
    void updateTempo();

    /**
     * Mets a jour le statut (started or not) sur l'ihm
     */
    void updateStarted();

    /**
     * Mets a jour le nombre de temps sur l'ihm
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
