package ru.s7.main_frame;

import ru.s7.stuff.AppPropertySaver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class TemplateAddressPanel extends JPanel {

    private final String PROP_ADDRESS_PATH = "template-address-path";
    private Properties prop;

    public TemplateAddressPanel(Properties prop){
        super();
        this.setLayout(new GridBagLayout());

        this.prop = prop;

        JTextField field = new JTextField();
        field.addActionListener(new TextFieldEditListener());

        field.setPreferredSize(new Dimension(230, 24));
        field.setText(prop.getProperty(PROP_ADDRESS_PATH).isEmpty()?"":prop.getProperty(PROP_ADDRESS_PATH));
        if(!field.getText().isEmpty()) new TextFieldEditListener().notifyObserver();

        PathButton pathButton = new PathButton(prop, PROP_ADDRESS_PATH, field);

        this.add(field);
        this.add(pathButton);

    }

   class TextFieldEditListener  implements ActionListener, Notifier{

       private java.util.List observers;

       @Override
       public void actionPerformed(ActionEvent actionEvent) {
           prop.setProperty(PROP_ADDRESS_PATH, "");
           AppPropertySaver.save(prop);
           notifyObserver();
       }

       @Override
       public void notifyObserver() {
           for (int i = 0; i < observers.size() ; i++){
               EventObserver obs = (EventObserver)observers.get(i);
               obs.update(Event.TEMPLATE_FILES_LIST );
           }
       }
   }


}
