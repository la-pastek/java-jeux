package Pong;

import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle {
    Random random;
    double xVelocity;
    double yVelocity;
    Ball(int x,int y,int wifth, int hieght){
        super(x,y,wifth,hieght);
        random = new Random();
        int randomXdirection = random.nextInt(2);
        int randomYdirection = random.nextInt(2);
        switch (randomYdirection) {
            case 0 -> { randomYdirection--; setYDirection(randomYdirection); }
            case 1 -> { randomYdirection =0; randomYdirection++; setYDirection(randomYdirection); }
        }
        switch (randomXdirection) {
            case 0 -> { randomXdirection--; setXDirection(randomXdirection); }
            case 1 -> { randomXdirection=0; randomXdirection++; setXDirection(randomXdirection); }
        }
    }

    public void setYDirection(double randomYDirection){yVelocity=randomYDirection;}
    public void setXDirection(double randomXDirection){xVelocity=randomXDirection;}
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x,y,width,height);
    }
    public void move(){
        x +=xVelocity;
        y +=yVelocity;
    }
}
