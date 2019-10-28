package ru.s7.main_frame;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class ResultAddressPanel extends JPanel {

    public ResultAddressPanel(Properties prop){
        super();
        this.setLayout(new GridBagLayout());

        JTextField field = new JTextField();

        field.setPreferredSize(new Dimension(230, 24));
        PathButton pathButton = new PathButton(prop,"result-address-path", field);

        this.add(field);
        this.add(pathButton);

    }

}
