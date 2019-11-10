package ru.s7.main_frame;

import ru.s7.main_frame.oscmd.MainPanel;
import javax.swing.*;
import java.util.Properties;

public class MainFrame extends JFrame {

    public MainFrame(Properties prop) {
        init(prop);
        this.add(new MainPanel(prop));
    }

    private void init(Properties prop){
        this.setIconImage( new ImageIcon(prop.getProperty("main-frame-icon-logo-path")).getImage() );
        this.setTitle(prop.getProperty("main-frame-title"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int x = Integer.decode(prop.getProperty("main-frame-x"));
        int y = Integer.decode(prop.getProperty("main-frame-y"));
        int width = Integer.decode(prop.getProperty("main-frame-width"));
        int height = Integer.decode(prop.getProperty("main-frame-height"));

        this.setBounds(x, y, width, height);
    }

}
