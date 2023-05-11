package BeatBox;

import java.awt.*;

public class Game extends Thread{

    public String titleName;
    public String difficulty;
    public String musicName;

    private Music gameMusic;
    public Game(String titleName,String difficulty,String musicName){
        this.titleName = titleName;
        this.difficulty=difficulty;
        this.musicName=musicName;
        gameMusic = new Music("../Resources/"+ this.musicName,false);
        gameMusic.start();
    }
    public BeatClass bc;
    public void screenDraw(Graphics2D g){

    }
    @Override
    public void run(){

    }
    public void Press(int n){
        bc.effect.get(n).setVisible(true);
    }
    public void Release(int n){
        bc.effect.get(n).setVisible(false);
    }
    public void close(){
        gameMusic.close();
        this.interrupt();
    }


}
