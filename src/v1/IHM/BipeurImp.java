package v1.IHM;

import javafx.scene.media.AudioClip;

import java.net.URL;

public class BipeurImp implements Bipeur{

    final URL tempo = getClass().getResource("/Audio/beep-07.wav");
    final URL mesure = getClass().getResource("/Audio/beep-08b.wav");

    final AudioClip soundTempo = new AudioClip(tempo.toString());
    final AudioClip soundMesure = new AudioClip(mesure.toString());

    @Override
    public void playTempo() {
        soundTempo.play();
    }

    @Override
    public void playMesure() {
        soundMesure.play();
    }
}
