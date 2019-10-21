package ru.s7.main_frame;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
            //fileopen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileopen.setFileFilter(new FileNameExtensionFilter("JRXML File", "jrxml"));
            fileopen.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );

            int ret = fileopen.showDialog(null, "Открыть файл");

            System.out.println("Path without file.jrxml : " + fileopen.getSelectedFile().isFile() + " : " + fileopen.getSelectedFile().getName());

            String sPath = fileopen.getSelectedFile().getPath().replaceAll(fileopen.getSelectedFile().getName(), "");

            System.out.println("RESULT: " + (fileopen.getSelectedFile().isFile()==false?fileopen.getSelectedFile().getPath():sPath));


            if (ret==0){
                path.setText( (fileopen.getSelectedFile().isFile()==false?fileopen.getSelectedFile().getPath():sPath) );
            } else {
                path.setText("");
            }

        }
    }

}
