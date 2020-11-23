/**
 * @author khom
 */
//
    /*
    Description: Panel to layout buttons and graphics area.

     */
    /*
    Author : Khom
    Date : November, 2020
     */


//The JPanel which organizes the GUI

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

///////////////////////////////////////////////  BBPanel
public class BBPanel extends JPanel{
    BallInBox m_bb;     // The bouncing ball panel

    //============================================ constructor
    /** Creates a panel with the controls and bouncing ball display. */
    BBPanel(){
        //... Create components
        m_bb = new BallInBox();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        //... Add Listeners
        startButton.addActionListener(new StartAction());
        stopButton.addActionListener(new StopAction());

        //... Layout inner panel with two buttons horizontally
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        //... Layout outer panel with button panel above bouncing ball
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(m_bb   , BorderLayout.CENTER);
    } // end constructor


    ///////////////////////////////////////////////   inner listener class StartAction
    class StartAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            m_bb.setAnimation(true);
        }
    }

    //////////////////////////////////////////////    inner listener class StopAction
    class StopAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            m_bb.setAnimation(false);
        }
    }
}//endclass BBPanel
