package BeatBox;

import javax.swing.*;
public class Note extends Thread{

    public BeatClass bc;
    public JLabel note;
    int x;
    public int y;
    float speed = 3;
    public int set=0;
    int noteType;
    float noteLength;
    public Note(BeatClass _bc,int sp, int x,int y,float l,int type){
        bc=_bc;
        this.x =x;
        this.y = y;
        noteType=type;
        noteLength=l;
        note = new JLabel(new ImageIcon(getClass().getResource("images/Note1.png")));
        note.setBounds(x,y,99,30);
    }

    public void Drop(){
        y+=speed;

        note.setBounds(x,y,99,30);
        //System.out.println(y);
        if((y>380&&y<390)||(y>420&&y<440)){
            set=1;
        }else if(y>=390&&y<=420){
            set=2;
        }else{
            set=0;
        }
        if(y>500){

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
