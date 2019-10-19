package ru.s7.main_frame;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class MainFrame extends JFrame {

    public MainFrame(Properties prop) {

        this.setTitle(prop.getProperty("main-frame-title"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int x = Integer.decode(prop.getProperty("main-frame-x"));
        int y = Integer.decode(prop.getProperty("main-frame-y"));
        int width = Integer.decode(prop.getProperty("main-frame-width"));
        int height = Integer.decode(prop.getProperty("main-frame-height"));

        this.setBounds(x, y, width, height);

        JPanel panel = new JPanel();
        //this.add(panel);
        panel.setLayout(new GridLayout(7, 3));
        //panel.setLayout(new GridBagLayout());

        panel.add(new JLabel(prop.getProperty("main-frame-before-studio-btn-comment")));
        panel.add(new StudioButton(prop));
        panel.add(new JLabel(prop.getProperty("main-frame-before-addr-temp-comment")));
        panel.add(new TemplateAddressPanel(prop));

        this.add(panel);
    }

}
