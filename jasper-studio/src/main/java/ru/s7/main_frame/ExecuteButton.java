package ru.s7.main_frame;

import net.sf.jasperreports.engine.JRException;
import ru.s7.report.ReportFileTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

public class ExecuteButton extends JButton {

    private String selectedReportName;
    private ExecuteButton executeButton;
    private Properties prop;
    private ConcreteObserver observer;

    public void setSelectedReportName(String selectedReportName){
        this.selectedReportName = selectedReportName;
    }

    public void setVisible(boolean visible){
        this.setEnabled(visible);
    }

    public ExecuteButton(Properties prop, ConcreteObserver observer)
    {
        this.prop = prop;
        executeButton = this;
        this.setEnabled(false);
        this.setText(prop.getProperty("execute-button-text"));
        this.setPreferredSize(new Dimension(50, 24));
        this.addActionListener(new ButtonEventListener());
        this.observer = observer;
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println( "Execute report -> " + selectedReportName );
            System.out.println("Full path: "+ prop.getProperty("template-address-path"));

            try {
                ReportFileTemplate reportFileTemplate = new ReportFileTemplate(prop.getProperty("template-address-path"), selectedReportName,prop.getProperty("result-address-path"));
                new ru.s7.report.ReportCreator(reportFileTemplate);
                observer.notice(EventType.SUCCESS);
            } catch (JRException | IOException ex) {
                ex.printStackTrace();
            }

            executeButton.setEnabled(false);


        }
    }

}
