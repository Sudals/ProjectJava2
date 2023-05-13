package BeatBox;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Note extends Thread{

    public JLabel note;
    int x;
    int y;
    float speed = 1;
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
    }
    public void run(){
        try{
            Drop();
            Thread.sleep(Main.SLEEP_TIME);
        }catch (Exception e){

        }
    }
}
