package ru.s7.main_frame.oscmd;

import ru.s7.main_frame.ExecuteButton;
import ru.s7.main_frame.TemplatePane;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Properties;

public class ResultPane extends JScrollPane {
    private JList listTemplate;
    private ExecuteButton executeButton;

    public ResultPane(Properties prop, ExecuteButton executeButton){

        this.executeButton = executeButton;

        String[] resultTestList = {"ReportTest1.rpt", "ReportTest2.rpt", "ReportTest3.rpt", "ReportTest4.rpt",
                "ReportTest5.rpt", "ReportTest6.rpt", "ReportTest7.rpt", "ReportTest8.rpt",
                "ReportTest9.rpt", "ReportTest10.rpt", "ReportTest11.rpt", "ReportTest12.rpt",
                "ReportTest13.rpt", "ReportTest14.rpt", "ReportTest15.rpt", "ReportTest16.rpt"
                };

        listTemplate  = new JList(resultTestList);
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
