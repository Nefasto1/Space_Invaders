package sdm.gui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;

class Player {
    Clip clip;
    String menuAudioPath = "resources/menu.wav";
    String backgroundAudio = "resources/audioSpace.wav";
    String gameOverPath = "resources/gameOver.wav";
    String projectilePath = "resources/shot.wav";
    String victoryPath = "resources/victory.wav";

    void playMusic(String musicLoc){
        try {
            File musicPath = new File(musicLoc);
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    void setMenuAudio(){
        playMusic(menuAudioPath);
    }
    void setBackgroundAudio(){
        stopMusic();
        playMusic(backgroundAudio);
    }
    void setGameOverAudio(){
        stopMusic();
        playMusic(gameOverPath);
    }
    void setProjectileAudio(){
        stopMusic();
        playMusic(projectilePath);
    }
    void setVictoryAudio(){
        stopMusic();
        playMusic(victoryPath);
    }

    void stopMusic(){
        if (clip != null && clip.isRunning()) {
        clip.stop();
        clip.close();}
    }
}