package Pong;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;



public class main {

    public static void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("F:\\IdeaProjects\\Pong-Game\\src\\main\\java\\Pong\\WATEVA-Ping-Pong-Party-_NCS-Release_.wav");
        AudioInputStream  audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

    //String path = "src/main/data/audio/WATEVA - Ping Pong Party [NCS Release].mp3";
    Frames frames = new Frames();
    play();
    }
}
