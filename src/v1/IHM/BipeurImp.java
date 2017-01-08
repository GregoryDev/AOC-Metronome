package v1.IHM;

import javafx.scene.media.AudioClip;

import java.net.URL;

public class BipeurImp implements Bipeur{

    private URL tempo = getClass().getResource("/v1/Audio/beep-07.wav");
    private URL mesure = getClass().getResource("/v1/Audio/beep-08b.wav");

    private AudioClip soundTempo = new AudioClip(tempo.toString());
    private AudioClip soundMesure = new AudioClip(mesure.toString());

    private Ihm ihm;

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

        private Highlight(String type) {
            this.type = type;
        }

        public void run() {
            ihm.switchLed(type);
            while (soundTempo.isPlaying() || soundMesure.isPlaying()) {}
            ihm.switchLed(type);
        }

    }
}
