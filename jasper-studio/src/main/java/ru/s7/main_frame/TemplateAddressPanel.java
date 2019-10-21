package ru.s7.main_frame;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class TemplateAddressPanel extends JPanel {

    public TemplateAddressPanel(Properties prop){
        super();
        this.setLayout(new GridBagLayout());

        JTextField field = new JTextField();

        field.setPreferredSize(new Dimension(230, 24));
        PathButton pathButton = new PathButton(prop, field);

        this.add(field);
        this.add(pathButton);

    }



}
