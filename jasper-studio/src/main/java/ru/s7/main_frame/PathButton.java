package ru.s7.main_frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class PathButton extends JButton
{
    private JTextField path;

    public PathButton(Properties prop, JTextField path)
    {
        this.path = path;
        this.setText(prop.getProperty("path-button-text"));
        this.setPreferredSize(new Dimension(24, 24));
        this.addActionListener(new ButtonEventListener());
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fileopen = new JFileChooser();
            fileopen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int ret = fileopen.showDialog(null, "Открыть файл");

            if (ret==0){
                path.setText( fileopen.getSelectedFile().getPath() );
            } else {
                path.setText("");
            }

        }
    }

}
