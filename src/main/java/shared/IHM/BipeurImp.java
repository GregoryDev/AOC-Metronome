package shared.IHM;

import javafx.scene.media.AudioClip;

import java.net.URL;

public class BipeurImp implements Bipeur{

    private URL tempo = getClass().getResource("/beep-07.wav");
    private URL mesure = getClass().getResource("/beep-08b.wav");

    private AudioClip soundTempo = new AudioClip(tempo.toString());
    private AudioClip soundMesure = new AudioClip(mesure.toString());

    private Ihm ihm;

    /**
     * Constructeur du bipeur
     * @param ihm l'ihm interagissant avec ce bipeur
     */
    public BipeurImp(Ihm ihm) {
        this.ihm = ihm;
    }

    @Override
    public void playTempo() {
        soundTempo.play();
        (new Thread(new Highlight("tempo"))).start();
    }

    @Override
    public void playMesure() {
        soundMesure.play();
        (new Thread(new Highlight("mesure"))).start();
    }

    private class Highlight implements Runnable {

        private String type;

        /**
         * Creation d'un thread permettant d'allumer la bonne led le temps du son correspondant
         * @param type le type de led a allumer
         */
        private Highlight(String type) {
            this.type = type;
        }

        /**
         * Execution du thread
         */
        public void run() {
            ihm.switchLed(type);
            while (soundTempo.isPlaying() || soundMesure.isPlaying()) {}
            ihm.switchLed(type);
        }

    }
}
