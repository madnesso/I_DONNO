package Games;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyinput extends KeyAdapter {
    private Handler handler;

    public Keyinput(Handler handler){
        this.handler = handler;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i <handler.object.size() ; i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Player){
                //key events for player 1

                if (key == KeyEvent.VK_W) tempObject.setVely(-5);
                if (key == KeyEvent.VK_S) tempObject.setVely(5);
                if (key == KeyEvent.VK_A) tempObject.setVelx(-5);
                if (key == KeyEvent.VK_D) tempObject.setVelx(5);
            }
            else if (tempObject.getId() == ID.Player2){
                //key events for player 1

                if (key == KeyEvent.VK_UP) tempObject.setVely(-5);
                if (key == KeyEvent.VK_DOWN) tempObject.setVely(5);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelx(-5);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelx(5);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i <handler.object.size() ; i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Player){
                //key events for player 1

                if (key == KeyEvent.VK_W) tempObject.setVely(0);
                if (key == KeyEvent.VK_S) tempObject.setVely(0);
                if (key == KeyEvent.VK_A) tempObject.setVelx(0);
                if (key == KeyEvent.VK_D) tempObject.setVelx(0);
            }
            else if (tempObject.getId() == ID.Player2){
                //key events for player 1

                if (key == KeyEvent.VK_UP) tempObject.setVely(0);
                if (key == KeyEvent.VK_DOWN) tempObject.setVely(0);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelx(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelx(0);
            }
        }
    }
}
