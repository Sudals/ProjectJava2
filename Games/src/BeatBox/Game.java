package BeatBox;

import java.awt.*;
import java.util.Random;

public class Game extends Thread{

    public String titleName;
    public String difficulty;
    public String musicName;
    public Music gameMusic;
    public Game(String titleName,String difficulty,String musicName){
        this.titleName = titleName;
        this.difficulty=difficulty;
        this.musicName=musicName;
        gameMusic = new Music("../Resources/"+ this.musicName,false);
        //gameMusic.start();
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
        gameMusic.start();
        Beat[] beats=new Beat[(int)FrequencyAnalysis.onsets.stream().count()];
        for(int i = 0 ; i<FrequencyAnalysis.onsets.stream().count();i++) {
            System.out.println(FrequencyAnalysis.onsets.stream().count()+"/"+i);
            Random random = new Random();
            int randomNumber = random.nextInt(6) + 1;
            switch (randomNumber){
                case 1:
                    beats[i] = new Beat((int) (FrequencyAnalysis.times.get(i) * 1000), "A");
                    break;
                case 2:
                    beats[i] = new Beat((int) (FrequencyAnalysis.times.get(i) * 1000), "S");
                    break;
                case 3:
                    beats[i] = new Beat((int) (FrequencyAnalysis.times.get(i) * 1000), "D");
                    break;
                case 4:
                    beats[i] = new Beat((int) (FrequencyAnalysis.times.get(i) * 1000), "J");
                    break;
                case 5:
                    beats[i] = new Beat((int) (FrequencyAnalysis.times.get(i) * 1000), "K");
                    break;
                case 6:
                    beats[i] = new Beat((int) (FrequencyAnalysis.times.get(i) * 1000), "L");
                    break;
            }

        }
        int i = 0;
        while(true){
            if(beats[i].time<=gameMusic.getTime()){
                Note note = null;
                switch(beats[i].noteName){
                    case "A":
                        note = bc.slot1();
                        break;
                    case "S":
                        note = bc.slot2();
                        break;
                    case "D":
                        note = bc.slot3();
                        break;
                    case "J":
                        note = bc.slot4();
                        break;
                    case "K":
                        note = bc.slot5();
                        break;
                    case "L":
                        note = bc.slot6();
                        break;
                };
                if(note !=null) {

                }
                i++;
            }
        }
    }

}
