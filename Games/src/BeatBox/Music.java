package BeatBox;

import javazoom.jl.player.Player;
import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Music extends Thread{
    private Player player;
    private boolean isLoop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;
    public boolean isPaused;
    public Music(String name, boolean isLoop){
        try{
            this.isLoop=isLoop;
            file=new File(Main.class.getResource("../Resources/"+name).toURI());
            fis=new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }catch(Exception e){
            System.out.println((e.getMessage()));
        }
    }
    public int getTime(){
        if(player==null){
            return 0;
        }
        return player.getPosition();
    }
    public void close(){
        isLoop=false;
        player.close();
        this.interrupt();
    }
  public void pause() throws InterruptedException {
        player.wait();
  }
    public void run(){
        try{
            do{
                player.play();
            }while(isLoop);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
