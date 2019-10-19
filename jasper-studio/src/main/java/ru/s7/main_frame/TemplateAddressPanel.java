package ru.s7.main_frame;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class TemplateAddressPanel extends JPanel {

    public TemplateAddressPanel(Properties prop){
        super();
        this.setLayout(new GridBagLayout());
        this.add(new JLabel("PPanel"));

        JTextField field = new JTextField();
        //field.setColumns ( 18 );
        //JButton btn = new JButton("...");
        //btn.setPreferredSize(new Dimension(24, 24));

        field.setPreferredSize(new Dimension(230, 24));
        this.add(field);
        //this.add(btn);

        this.add(new PathButton(prop));

        /*
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        panel.add(fileopen);
        */
    }



}
