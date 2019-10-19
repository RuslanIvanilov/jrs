package ru.s7.main_frame;

import ru.s7.main_frame.oscmd.OsCmdFactory;
import ru.s7.main_frame.oscmd.OsSystemProperty;
import ru.s7.main_frame.oscmd.OsType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

public class StudioButton extends JButton {

    public StudioButton(Properties prop){
        this.setText(prop.getProperty("studio-button-text"));
        this.setPreferredSize(new Dimension(200, 24));
        this.addActionListener(new ButtonEventListener());
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            OsSystemProperty property = new OsSystemProperty();
            OsType osType = property.getOsSystemPropertyType();

            try {
                new OsCmdFactory().executeOsCmd(property,osType);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

}
