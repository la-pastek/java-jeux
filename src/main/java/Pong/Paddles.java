package Pong;
import java.awt.*;
import java.awt.event.*;

public class Paddles extends Rectangle {

    int id;
    int yVelocity;
    int speed = 1 ;
    Paddles(int X, int y,  int pW,int pH,int id){
        super(X,y,pW,pH);
        this.id=id;
    }

    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1 -> {
                if (e.getKeyCode() == KeyEvent.VK_Z) {setYDirection(-speed);}
                if (e.getKeyCode() == KeyEvent.VK_S) {setYDirection(speed);}}
            case 2 -> {
                if (e.getKeyCode() == KeyEvent.VK_P) {setYDirection(-speed);}
                if (e.getKeyCode() == KeyEvent.VK_M) {setYDirection(speed);}
            }
        }
    }
    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1 -> {
                if (e.getKeyCode() == KeyEvent.VK_Z) {setYDirection(0);}
                if (e.getKeyCode() == KeyEvent.VK_S) {setYDirection(0);}}
            case 2 -> {
                if (e.getKeyCode() == KeyEvent.VK_P) {setYDirection(0);}
                if (e.getKeyCode() == KeyEvent.VK_M) {setYDirection(0);}
            }
        }
        }
    public void  move(){
        y = y+yVelocity;
    }
    public void setYDirection(int yDirection){
        yVelocity = yDirection;
    }
    public void draw(Graphics g){
            g.setColor(Color.white);
            g.fillRect(x,y,width,height);
    }

}
