package Pong;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Panel extends JPanel implements Runnable{

    static final int Game_WIDTH = 1000;
    static final int Game_HEIGHT = (int)(Game_WIDTH*(0.555));
    static final Dimension SCREEN_size = new Dimension(Game_WIDTH,Game_HEIGHT);
    static final int Ball_Diameter = 20;
    static final int Paddle_Height= 100;
    static final int Paddle_Widh = 25;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Ball ball ;
    Score score;
    Paddles paddle1;
    Paddles paddle2;

    Panel(){
        newPaddles();
        newBall();
        score = new Score(Game_WIDTH,Game_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_size);
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void newBall(){
        random = new Random();
        ball = new Ball((Game_WIDTH/2)-(Ball_Diameter/2),(Game_HEIGHT/2)-(Ball_Diameter/2),Ball_Diameter,Ball_Diameter);
    }
    public void newPaddles(){
        paddle1 = new Paddles(0,(Game_HEIGHT/2)-(Paddle_Height/2),Paddle_Widh,Paddle_Height,1);
        paddle2 = new Paddles((Game_WIDTH-Paddle_Widh),(Game_HEIGHT/2)-(Paddle_Height/2),Paddle_Widh,Paddle_Height,2);
    }
    public void move(){
        paddle1.move();
        paddle2.move();
        ball.move();
    }
    public void draw(Graphics g){
    paddle1.draw(g);
    paddle2.draw(g);
    ball.draw(g);
    }
    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void chechCollision(){
        // stop ball
        if (ball.y<=0){
            ball.setYDirection(-ball.yVelocity);
        }
        if (ball.y>=Game_HEIGHT-Ball_Diameter){
            ball.setYDirection(-ball.yVelocity);
        }
        // stop by paddles
        if (ball.intersects(paddle1)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if (ball.intersects(paddle2)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        // stop paddles at the windows edge
        if (paddle1.y<0){
            paddle1.y=0;
        }if (paddle1.y>=Game_HEIGHT-Paddle_Height){
            paddle1.y=Game_HEIGHT-Paddle_Height;
        }

        if (paddle2.y<0){
            paddle2.y=0;
        }if (paddle2.y>=Game_HEIGHT-Paddle_Height){
            paddle2.y=Game_HEIGHT-Paddle_Height;
        }
        // point + new ball
        if (ball.x<= 0){
            score.player2++;
            newBall();
            newPaddles();
        }
        if (ball.x>= Game_WIDTH-Ball_Diameter){
            score.player1++;
            newBall();
            newPaddles();
        }
    }
    public void run(){
        //loop
        long lastTime =System.nanoTime();
        double amouifTick = 60.0;
        //if 1000000000 the ball is verry swall
        double ns = 150000000/amouifTick;
        double delta = 0;
        while (true){
            long now = System.nanoTime();
            delta+= (now -lastTime)/ns;
            lastTime = now;
            if (delta>=1){
                move();
                chechCollision();
                repaint();
                delta--;
            }
        }
    }
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
