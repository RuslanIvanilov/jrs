package ru.s7.main_frame;

import ru.s7.main_frame.ExecuteButton;
import ru.s7.main_frame.TemplatePane;
import ru.s7.stuff.PathUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Properties;

public class ResultPane extends JScrollPane implements Subscriber{
    private JList listResult;
    private ExecuteButton executeButton;
    private Properties prop;

    public ResultPane(Properties prop, ExecuteButton executeButton){
        this.prop = prop;
        this.executeButton = executeButton;
        fillFileList();
    }

    public void fillFileList()
    {
        String[] files = getFiles();
        listResult  = files != null ? new JList( files ): new JList();
        listResult.setLayoutOrientation(JList.VERTICAL);
        listResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listResult.addListSelectionListener(new ListEventListener());
        this.setViewportView(listResult);
    }

    private String[] getFiles(){
        if( !prop.getProperty("result-address-path").isEmpty() ){
            String[] files = new PathUtils().getFiles(prop.getProperty("result-address-path"), "pdf" );
            return files;
        } else{
            return null;
        }
    }

    @Override
    public void event(EventType eventType) {
        if(EventType.SUCCESS == eventType){
            fillFileList();
        }
    }

    class ListEventListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting() == false) {
               // executeButton.setEnabled(true);
               // executeButton.setSelectedReportName((String)listResult.getSelectedValue());
                System.out.println("Selected report : " + (String)listResult.getSelectedValue() );
            }
        }
    }
}
