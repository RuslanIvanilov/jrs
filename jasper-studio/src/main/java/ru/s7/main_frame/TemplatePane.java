package ru.s7.main_frame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Properties;

public class TemplatePane extends JScrollPane {

    private JList listTemplate;
    private ExecuteButton executeButton;

    public TemplatePane(Properties prop, ExecuteButton executeButton){

        this.executeButton = executeButton;

        String[] templTestList = { "Report1.jrxml", "Report2.jrxml", "Report3.jrxml", "Report4.jrxml",
                "Report5.jrxml", "Report6.jrxml", "Report7.jrxml", "Report8.jrxml",
                "Report9.jrxml", "Report10.jrxml", "Report11.jrxml", "Report12.jrxml",
                "Report13.jrxml", "Report14.jrxml", "Report15.jrxml", "Report16.jrxml"
        };

        listTemplate  = new JList(templTestList);
        listTemplate.setLayoutOrientation(JList.VERTICAL);
        listTemplate.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listTemplate.addListSelectionListener(new ListEventListener());

        this.setViewportView(listTemplate);
    }

    class ListEventListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting() == false) {
                executeButton.setEnabled(true);
                executeButton.setSelectedReportName((String)listTemplate.getSelectedValue());
            }
        }
    }


}
