package Pong;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.black;
import static java.awt.Color.cyan;

public class Frames extends JFrame {

    Panel panel= new Panel();;
    Frames(){
        this.add(panel);
        this.setTitle("Pong");
        this.setResizable(false);
        this.setBackground(black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
