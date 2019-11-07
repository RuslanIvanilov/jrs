package ru.s7.main_frame;

import org.w3c.dom.ls.LSOutput;
import ru.s7.stuff.AppPropertySaver;
import ru.s7.stuff.FileReport;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class PathButton extends JButton
{
    private JTextField path;
    private Properties prop;
    private String propKey;
    private FileReport fileReport;

    public PathButton(Properties prop, String propKey, JTextField path, FileReport fileReport)
    {
        this.prop = prop;
        this.path = path;
        this.fileReport = fileReport;
        this.propKey = propKey;
        this.setText(prop.getProperty("path-button-text"));
        this.setPreferredSize(new Dimension(24, 24));
        this.addActionListener(new ButtonEventListener());

    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fileopen = new JFileChooser();
            //fileopen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileopen.setFileFilter(new FileNameExtensionFilter(fileReport.getDescription(), fileReport.getExtencion()));
            fileopen.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );

            int ret = fileopen.showDialog(null, "Открыть файл");

            //System.out.println("Path without file.jrxml : " + fileopen.getSelectedFile().isFile() + " : " + fileopen.getSelectedFile().getName());
            //String sPath = fileopen.getSelectedFile().getPath().replaceAll(fileopen.getSelectedFile().getName(), "");
            //System.out.println("RESULT: " + (fileopen.getSelectedFile().isFile()==false?fileopen.getSelectedFile().getPath():sPath));

            if (ret==0){
                String sPath = fileopen.getSelectedFile().getPath().replaceAll(fileopen.getSelectedFile().getName(), "");
                path.setText( (fileopen.getSelectedFile().isFile()==false?fileopen.getSelectedFile().getPath():sPath) );
                System.out.println("Path text for save ["+path.getText()+"]");
                prop.setProperty(propKey,path.getText());
                AppPropertySaver.save(prop);
            } /*else {
                path.setText("");
            }*/

        }
    }

}
