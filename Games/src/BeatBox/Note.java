package BeatBox;

import javax.swing.*;
public class Note extends Thread{

    public BeatClass bc;
    public JLabel note;
    int x;
    int y;
    float speed = 3;
    int noteType;
    float noteLength;
    public Note(BeatClass _bc,int sp, int x,int y,float l,int type){
        bc=_bc;
        this.x =x;
        this.y = y;
        noteType=type;
        noteLength=l;
        note = new JLabel(new ImageIcon(getClass().getResource("../images/Note1.png")));
        note.setBounds(x,y,99,30);
    }

    public void Drop(){
        y+=speed;

        note.setBounds(x,y,99,30);

        if(y>280){
            bc.RemoveNote(noteType,this);
        }
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
