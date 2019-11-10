package ru.s7.main_frame;

import ru.s7.stuff.PathUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Properties;

public class TemplatePane extends JScrollPane implements Subscriber{

    private JList listTemplate;
    private ExecuteButton executeButton;
    private Properties prop;

    public TemplatePane(Properties prop, ExecuteButton executeButton){
        this.prop = prop;
        this.executeButton = executeButton;
        fillFileList();
    }

    public void fillFileList()
    {
        //this.repaint();
        String[] files = getFiles();
        listTemplate  = files != null ? new JList( files ): new JList();
        listTemplate.setLayoutOrientation(JList.VERTICAL);
        listTemplate.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listTemplate.addListSelectionListener(new ListEventListener());
        this.setViewportView(listTemplate);
    }


    private String[] getFiles(){
        if( !prop.getProperty("template-address-path").isEmpty() ){
            String[] files = new PathUtils().getFiles(prop.getProperty("template-address-path"), ".jrxml" );
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
                executeButton.setEnabled(true);
                executeButton.setSelectedReportName((String)listTemplate.getSelectedValue());
            }
        }
    }




}
