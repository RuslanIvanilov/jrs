package ru.s7.main_frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class PathButton extends JButton {

    public PathButton(Properties prop){
        this.setText(prop.getProperty("path-button-text"));
        this.setPreferredSize(new Dimension(24, 24));
        this.addActionListener(new ButtonEventListener());
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(" Action from path button. ");

        }
    }

}
