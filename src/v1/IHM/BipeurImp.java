package v1.IHM;

import javafx.scene.media.AudioClip;

import java.net.URL;

public class BipeurImp implements Bipeur{

    final private URL tempo = getClass().getResource("/v1/Audio/beep-07.wav");
    final private URL mesure = getClass().getResource("/v1/Audio/beep-08b.wav");

    final private AudioClip soundTempo = new AudioClip(tempo.toString());
    final private AudioClip soundMesure = new AudioClip(mesure.toString());

    @Override
    public void playTempo() {System.out.println(this);
        soundTempo.play();
    }

    @Override
    public void playMesure() {
        soundMesure.play();
    }
}
