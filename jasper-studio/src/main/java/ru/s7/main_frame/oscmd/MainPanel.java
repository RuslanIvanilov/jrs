package ru.s7.main_frame.oscmd;

import ru.s7.main_frame.*;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class MainPanel extends JPanel {

    private Properties prop;
    private GridBagConstraints constraints = new GridBagConstraints();
    private ConcreteObserver observer = new ConcreteObserver();

    public MainPanel(Properties prop){
        super();
        this.prop = prop;
        this.setLayout(new GridBagLayout());
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        addLogo();

        this.add(new JLabel(prop.getProperty("main-frame-before-studio-btn-comment")), constraints);
        this.add(new StudioButton(prop),constraints);

        this.add(new JLabel(" ") ,constraints);

        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();

        JPanel panelSubMain = new JPanel();
        panelSubMain.setLayout(new GridLayout(1,2));

        panelLeft.add(new JLabel(prop.getProperty("main-frame-before-addr-temp-comment")));
        panelLeft.add(new TemplateAddressPanel(prop, observer));
        panelRight.add(new JLabel(prop.getProperty("main-frame-before-addr-result-comment")));
        panelRight.add(new ResultAddressPanel(prop));

        panelSubMain.add(panelLeft);

        panelSubMain.add(panelRight);

        this.add(panelSubMain, constraints);

        JPanel panelListMain = new JPanel();
        panelListMain.setLayout(new GridLayout(1,2));

        ExecuteButton executeButton = new ExecuteButton(prop, observer);

        TemplatePane templatePane = new TemplatePane(prop, executeButton);
        observer.addSubscriber(templatePane);

        panelListMain.add(templatePane);

        ResultPane resultPane = new ResultPane(prop, executeButton);
        observer.addSubscriber(resultPane);
        panelListMain.add(resultPane);

        this.add(panelListMain, constraints);

        this.add(new JLabel(" "),constraints);
        this.add(executeButton,constraints);

    }

    private void addLogo(){
        ImageIcon icon = new ImageIcon(prop.getProperty("main-frame-logo-path"));
        JLabel logo = new JLabel();
        logo.setIcon(icon);
        this.add( logo , constraints);
        this.add(new JLabel(" "), constraints);
    }


}
