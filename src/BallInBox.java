/**
 * @author khom
 */

/*
    Description: This Graphics panel simulates a ball bouncing in a box.
                Animation is done by changing instance variables
                in the timer's actionListener, then calling repaint().
                * Flicker can be reduced by drawing into a BufferedImage.
                  and/or using a clip region.
                * The edge of the oval could be animated (using Graphics2).

     */
    /*
    Author : Khom
    Date : November, 2020
     */

//The graphics panel that does the animation.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

////////////////////////////////////////////////////////////    BouncingBall
public class BallInBox extends JPanel{
      //============================================ fields
    //... Instance variables representing the ball.
    private Ball m_ball = new Ball(0, 0, 2, 3);

    //... Instance variables for the animation
    private int m_interval = 35;    // Milliseconds between updates.
    private Timer m_timer;              // Timer fires to animate one step.

    //==================================================  constructor
    /**
     * Set panel size and creates timer.
     */
    public BallInBox(){
        setPreferredSize(new Dimension(200, 80));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        m_timer = new Timer(m_interval, new TimerAction());
    }

    //====================================================  setAnimation
    /** Turn animation on or off.
     * @param turnOnOff Specifies state of animation.
     */
    public void setAnimation(boolean turnOnOff){
        if(turnOnOff){
            m_timer.start();        // start animation by starting the timer.
        }else {
            m_timer.stop();     // stop timer
        }
    }

    //=================================================== paintComponent
    public void paintComponent(Graphics g){
        super.paintComponent(g);            // Paint background, border
        m_ball.draw(g);                     // Draw the ball.
    }

    //////////////////////////////////// inner listener class ActionListener
    class TimerAction implements ActionListener {
        //============================================ actionPerformed
        /** ActionListener of the timer. Each time this is called,
         *  the ball's position is updated, creating the appearance of
         *  movement.
         * @param e This ActionEvent parameter is unused.
         */
        public void actionPerformed(ActionEvent e){
            m_ball.setBounds(getWidth(), getHeight());
            m_ball.move();      // Move the ball.
            repaint();          // Repaint indirectly calls paintComponent.
        }
    }
}// endClass
