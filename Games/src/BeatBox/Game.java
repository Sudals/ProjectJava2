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
        dropNotes();
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
    public void dropNotes(){
        FrequencyAnalysis.mainEvent();
        Beat[] beats= {
                new Beat(1000,"S"),
                new Beat(2000,"D"),
                new Beat(3000,"F"),
        };
        int i = 0;
        while(true){
            if(beats[i].time<=gameMusic.getTime()){
                Note note = null;
                switch(i){
                    case 0:
                        note = bc.slot1();
                        break;
                    case 1:
                        note = bc.slot2();
                        break;
                    case 2:
                        note = bc.slot3();
                        break;
                };
                if(note !=null) {

                }
                i++;
            }
        }
    }

}
