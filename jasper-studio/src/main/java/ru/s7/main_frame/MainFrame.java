package ru.s7.main_frame;

import ru.s7.main_frame.oscmd.ResultPane;

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
        //panel.setLayout(new GridLayout(7, 3));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        panel.add(new JLabel(prop.getProperty("main-frame-before-studio-btn-comment")), constraints);
        panel.add(new StudioButton(prop),constraints);
        panel.add(new JLabel(" "),constraints);

        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();

        JPanel panelSubMain = new JPanel();
        panelSubMain.setLayout(new GridLayout(1,2));

        panelLeft.add(new JLabel(prop.getProperty("main-frame-before-addr-temp-comment")));
        panelLeft.add(new TemplateAddressPanel(prop));
        panelRight.add(new JLabel(prop.getProperty("main-frame-before-addr-result-comment")));
        panelRight.add(new ResultAddressPanel(prop));

        panelSubMain.add(panelLeft);

        panelSubMain.add(panelRight);

        panel.add(panelSubMain, constraints);

        JPanel panelListMain = new JPanel();
        panelListMain.setLayout(new GridLayout(1,2));

        ExecuteButton executeButton = new ExecuteButton(prop);

        panelListMain.add(new TemplatePane(prop, executeButton));
        panelListMain.add(new ResultPane(prop, executeButton));

        panel.add(panelListMain, constraints);

        panel.add(new JLabel(" "),constraints);
        panel.add(executeButton,constraints);

        this.add(panel);
    }

}
