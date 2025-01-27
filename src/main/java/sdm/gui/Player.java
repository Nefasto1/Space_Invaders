package sdm.gui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.*;

public class Player {
    private static Clip clip;
    private static void playMusic(String musicLoc){
        try {
            File musicPath = new File(musicLoc);
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volumeControl.setValue(-10f);
                if (musicLoc.contains("background")){
                    volumeControl.setValue(-20f);
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
                clip.start();

            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void setMenuAudio(){
        String menuAudioPath = "resources/audio/menu.wav";
        playMusic(menuAudioPath);
    }

    public static void setBackgroundAudio(){
        String backgroundAudio = "resources/audio/background.wav";
        stopMusic();
        playMusic(backgroundAudio);
    }
    public static void setGameOverAudio(){
        String gameOverPath = "resources/audio/gameOver.wav";
        playMusic(gameOverPath);
    }
    public static void setProjectileAudio(){
        String projectilePath = "resources/audio/shot.wav";
        playMusic(projectilePath);
    }
    public static void setVictoryAudio(){
        String victoryPath = "resources/audio/victory.wav";
        playMusic(victoryPath);
    }

    public static void setDeadAudio(){
        String deadPath = "resources/audio/dead.wav";
        playMusic(deadPath);
    }

    private static void stopMusic(){
        if (clip != null && clip.isRunning()) {
        clip.stop();
        clip.close();}
    }
}