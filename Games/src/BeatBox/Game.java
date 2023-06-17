package BeatBox;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends Thread{
    FrequencyAnalysis frequencyAnalysis;
    public String titleName;
    public String difficulty;
    public String musicName;
    public Music gameMusic;
    public Game(String titleName,String difficulty,String musicName){
        this.titleName = titleName;
        this.difficulty=difficulty;
        this.musicName=musicName;
        frequencyAnalysis=new FrequencyAnalysis();
        gameMusic = new Music(this.musicName,false);
        //gameMusic.start();
    }
    public BeatClass bc;
    public void screenDraw(Graphics2D g){

    }
    public Timer timer = new Timer();
    public TimerTask task = new TimerTask() {
        @Override
        public void run() {
            bc.EndWindows();
        }
    };
    @Override
    public void run(){
        dropNotes();
    }
    public void Press(int n){
        bc.effect.get(n).setVisible(true);
        bc.PressJMT(n);

    }
    public void Release(int n){
        bc.effect.get(n).setVisible(false);
    }
    public void close(){
        gameMusic.close();
        this.interrupt();
    }
    public void dropNotes(){
        frequencyAnalysis.mainEvent();
        bc.StartWindows();
        gameMusic.start();
        Beat[] beats=new Beat[(int)frequencyAnalysis.onsets.stream().count()];
        for(int i = 0 ; i<(int)frequencyAnalysis.onsets.stream().count();i++) {
            //System.out.println(FrequencyAnalysis.onsets.stream().count()+"/"+i);
            Random random = new Random();
            int randomNumber = random.nextInt(6) + 1;
            switch (randomNumber){
                case 1:
                    beats[i] = new Beat((int) (frequencyAnalysis.times.get(i) * 1000), "A");
                    break;
                case 2:
                    beats[i] = new Beat((int) (frequencyAnalysis.times.get(i) * 1000), "S");
                    break;
                case 3:
                    beats[i] = new Beat((int) (frequencyAnalysis.times.get(i) * 1000), "D");
                    break;
                case 4:
                    beats[i] = new Beat((int) (frequencyAnalysis.times.get(i) * 1000), "J");
                    break;
                case 5:
                    beats[i] = new Beat((int) (frequencyAnalysis.times.get(i) * 1000), "K");
                    break;
                case 6:
                    beats[i] = new Beat((int) (frequencyAnalysis.times.get(i) * 1000), "L");
                    break;
            }

        }
        int s1=0,s2=0,s3=0,s4=0,s5=0,s6=0;
        int i = 0;
        int t=2500;
        while(beats.length-1!=i){
            //System.out.println(i);
            if(beats[i].time<=gameMusic.getTime()){
                Note note = null;
                switch(beats[i].noteName){
                    case "A":
                        if(i==0){
                            s1=i;
                        }else if(beats[i].time-beats[s1].time<t){
                            break;
                        }
                        note = bc.slot1();
                        break;
                    case "S":
                        if(i==0){
                            s2=i;
                        }else if(beats[i].time-beats[s2].time<t){
                            break;
                        }
                        note = bc.slot2();
                        break;
                    case "D":
                        if(i==0){
                            s3=i;
                        }else if(beats[i].time-beats[s3].time<t){
                            break;
                        }
                        note = bc.slot3();
                        break;
                    case "J":
                        if(i==0){
                            s4=i;
                        }else if(beats[i].time-beats[s4].time<t){
                            break;
                        }
                        note = bc.slot4();
                        break;
                    case "K":
                        if(i==0){
                            s5=i;
                        }else if(beats[i].time-beats[s5].time<t){
                            break;
                        }
                        note = bc.slot5();
                        break;
                    case "L":
                        if(i==0){
                            s6=i;
                        }else if(beats[i].time-beats[s6].time<t){
                            break;
                        }
                        note = bc.slot6();
                        break;
                };
                if(note !=null) {

                }
                i++;
            }

        }
        timer.schedule(task,5000);

    }

}
