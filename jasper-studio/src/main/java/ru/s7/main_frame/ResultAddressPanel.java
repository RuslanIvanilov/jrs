package ru.s7.main_frame;

import ru.s7.stuff.AppPropertySaver;
import ru.s7.stuff.FileReport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class ResultAddressPanel extends JPanel {

    private final String PROP_ADDRESS_PATH = "result-address-path";
    private Properties prop;

    public ResultAddressPanel(Properties prop){
        super();
        this.setLayout(new GridBagLayout());

        JTextField field = new JTextField();

        field.setPreferredSize(new Dimension(230, 24));

        field.addActionListener(new TextFieldEditListener());
        field.setText(prop.getProperty(PROP_ADDRESS_PATH).isEmpty()?"":prop.getProperty(PROP_ADDRESS_PATH));

        PathButton pathButton = new PathButton(prop,"result-address-path", field, new FileReport(" PDF file", "pdf"));

        this.add(field);
        this.add(pathButton);

    }

    class TextFieldEditListener  implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            prop.setProperty(PROP_ADDRESS_PATH, "");
            AppPropertySaver.save(prop);

        }
    }

}
