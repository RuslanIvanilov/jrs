package ru.s7.main_frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class ExecuteButton extends JButton {

    private String selectedReportName;

    public void setSelectedReportName(String selectedReportName){
        this.selectedReportName = selectedReportName;
    }

    public void setVisible(boolean visible){
        this.setEnabled(visible);
    }

    public ExecuteButton(Properties prop)
    {
        this.setEnabled(false);
        this.setText(prop.getProperty("execute-button-text"));
        this.setPreferredSize(new Dimension(50, 24));
        this.addActionListener(new ButtonEventListener());
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println( "Execute report -> " + selectedReportName );


        }
    }

}
