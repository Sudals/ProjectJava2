package BeatBox;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e){
        if(BeatClass.game==null){return;}
        System.out.println(e.getKeyCode());
        if(e.getKeyCode()==KeyEvent.VK_A){
            BeatClass.game.Press(0);
        }else if(e.getKeyCode()==KeyEvent.VK_S){
            BeatClass.game.Press(1);
        }else if(e.getKeyCode()==KeyEvent.VK_D){
            BeatClass.game.Press(2);
        }else if(e.getKeyCode()==KeyEvent.VK_SPACE){
            BeatClass.game.Press(7);
        }else if(e.getKeyCode()==KeyEvent.VK_J){
            BeatClass.game.Press(3);
        }else if(e.getKeyCode()==KeyEvent.VK_K){
            BeatClass.game.Press(4);
        }else if(e.getKeyCode()==KeyEvent.VK_L){
            BeatClass.game.Press(5);
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        if(BeatClass.game==null){return;}
        if(e.getKeyCode()==KeyEvent.VK_A){
            BeatClass.game.Release(0);
        }else if(e.getKeyCode()==KeyEvent.VK_S){
            BeatClass.game.Release(1);
        }else if(e.getKeyCode()==KeyEvent.VK_D){
            BeatClass.game.Release(2);
        }else if(e.getKeyCode()==KeyEvent.VK_SPACE){
            BeatClass.game.Release(7);
        }else if(e.getKeyCode()==KeyEvent.VK_J){
            BeatClass.game.Release(3);
        }else if(e.getKeyCode()==KeyEvent.VK_K){
            BeatClass.game.Release(4);
        }else if(e.getKeyCode()==KeyEvent.VK_L){
            BeatClass.game.Release(5);
        }
    }
}
