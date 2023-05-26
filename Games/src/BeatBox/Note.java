package BeatBox;

import javax.swing.*;
public class Note extends Thread{

    public JLabel note;
    int x;
    int y;
    float speed = 3;
    int noteType=0;
    float noteLength;
    public Note(int sp, int x,int y,float l,int type){
        this.x =x;
        this.y = y;
        noteType=type;
        noteLength=l;
        note = new JLabel(new ImageIcon(getClass().getResource("../images/Note.png")));
        note.setBounds(x,y,100,30);
    }

    public void Drop(){
        y+=speed;

        note.setBounds(x,y,100,30);
    }
    public void run(){
        try{
            while(true) {
                Drop();
                Thread.sleep(Main.SLEEP_TIME);
            }
        }catch (Exception e){

        }
    }
}
