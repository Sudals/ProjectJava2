package BeatBox;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class KeyListener extends KeyAdapter {

    private BeatClass beatClass;

    public KeyListener(BeatClass beatClass) {
        this.beatClass = beatClass;
        try {
            // 효과음 파일 로드
            soundClip = AudioSystem.getClip();
            soundClip.open(AudioSystem.getAudioInputStream(Main.class.getResource("Resources/notepadSound.wav")));
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    private Clip soundClip;




    @Override
    public void keyPressed(KeyEvent e) {
        if (BeatClass.game == null) {
            return;
        }
        System.out.println(e.getKeyText(e.getKeyCode()));
        if (e.getKeyText(e.getKeyCode()).equals(BeatClass.jc1)){
            playSoundEffect();
            BeatClass.game.Press(0);
        } else if (e.getKeyText(e.getKeyCode()).equals(BeatClass.jc2)) {
            playSoundEffect();
            BeatClass.game.Press(1);
        } else if (e.getKeyText(e.getKeyCode()).equals(BeatClass.jc3)) {
            playSoundEffect();
            BeatClass.game.Press(2);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            //BeatClass.game.Press(7);
        } else if (e.getKeyText(e.getKeyCode()).equals(BeatClass.jc4)) {
            playSoundEffect();
            BeatClass.game.Press(3);
        } else if (e.getKeyText(e.getKeyCode()).equals(BeatClass.jc5)) {
            playSoundEffect();
            BeatClass.game.Press(4);
        } else if (e.getKeyText(e.getKeyCode()).equals(BeatClass.jc6)) {
            playSoundEffect();
            BeatClass.game.Press(5);
        }
/*
        if (e.getKeyCode() == KeyEvent.VK_A ||
                e.getKeyCode() == KeyEvent.VK_S ||
                e.getKeyCode() == KeyEvent.VK_D ||
                e.getKeyCode() == KeyEvent.VK_J ||
                e.getKeyCode() == KeyEvent.VK_K ||
                e.getKeyCode() == KeyEvent.VK_L) {
            playSoundEffect();
        }*/
    }private void playSoundEffect() {
        if (soundClip.isRunning()) {
            soundClip.stop(); 
        }
        soundClip.setFramePosition(0); 
        soundClip.start(); 
    }


    @Override
    public void keyReleased(KeyEvent e) {
        if (BeatClass.game == null) {
            return;
        }
        if (e.getKeyText(e.getKeyCode()).equals(BeatClass.jc1)) {
            BeatClass.game.Release(0);
        } else if (e.getKeyText(e.getKeyCode()).equals(BeatClass.jc2)) {
            BeatClass.game.Release(1);
        } else if (e.getKeyText(e.getKeyCode()).equals(BeatClass.jc3)) {
            BeatClass.game.Release(2);

        } else if (e.getKeyText(e.getKeyCode()).equals(BeatClass.jc4)) {
            BeatClass.game.Release(3);
        } else if (e.getKeyText(e.getKeyCode()).equals(BeatClass.jc5)) {
            BeatClass.game.Release(4);
        } else if (e.getKeyText(e.getKeyCode()).equals(BeatClass.jc6)) {
            BeatClass.game.Release(5);
        }
    }
}
