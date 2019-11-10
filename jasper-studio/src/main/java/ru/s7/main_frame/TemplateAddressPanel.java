package ru.s7.main_frame;

import ru.s7.stuff.AppPropertySaver;
import ru.s7.stuff.FileReport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class TemplateAddressPanel extends JPanel{

    private final String PROP_ADDRESS_PATH = "template-address-path";
    private Properties prop;
    private ConcreteObserver observer;

    public TemplateAddressPanel(Properties prop, ConcreteObserver observer){
        super();
        this.setLayout(new GridBagLayout());
        this.observer = observer;

        this.prop = prop;

        JTextField field = new JTextField();
        field.addActionListener(new TextFieldEditListener());

        field.setPreferredSize(new Dimension(230, 24));
        field.setText(prop.getProperty(PROP_ADDRESS_PATH).isEmpty()?"":prop.getProperty(PROP_ADDRESS_PATH));

        PathButton pathButton = new PathButton(prop, PROP_ADDRESS_PATH, field, new FileReport("JRXML File", "jrxml") , observer);

        this.add(field);
        this.add(pathButton);

    }



    class TextFieldEditListener  implements ActionListener{
       @Override
       public void actionPerformed(ActionEvent actionEvent) {
           prop.setProperty(PROP_ADDRESS_PATH, "");
           AppPropertySaver.save(prop);

       }


   }


}
