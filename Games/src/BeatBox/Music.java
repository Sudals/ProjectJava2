package BeatBox;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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
            System.out.println("Resources/"+name);
            //file=new File(Main.class.getResource(name).toURI());
            //fis=new FileInputStream(name);
            //bis = new BufferedInputStream(fis);
            InputStream inputStream = getClass().getResourceAsStream(name);
            player = new Player(inputStream);
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
