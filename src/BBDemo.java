/**
 * @ author khom
 */
/*
This program does a simple animation. Animation is done by creating a timer which calls an ActionListener at fixed intervals (eg. every 35 milliseconds).
The listener tells the ball to move it's coordinates a little, then it repaints the panel. repaint() indirectly calls our
paintComponent() method, which then draws the ball with the updated coordinates.
 */
    /*
    Description: Illustrates animation with a ball bouncing in a box
    Possible extensions: faster/slower button.
     */
    /*
    Author : Khom
    Date : November, 2020
     */

// The main program and window creation.

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

////////////////////////////////////////////////////   BBDemo
public class BBDemo extends JApplet{

    //=============================================== applet constructor
    public BBDemo(){
        add(new BBPanel());
    }

    //=============================================== main
    public static void main(String[] args){
        JFrame win = new JFrame("Bouncing Ball Demo");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        win.setContentPane(new BBPanel());

        win.pack();
        win.setVisible(true);
    }
}//endclass BBDemo
