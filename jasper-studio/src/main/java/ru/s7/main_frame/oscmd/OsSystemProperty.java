package ru.s7.main_frame.oscmd;

import ru.s7.main_frame.AppProperty;

import java.util.Properties;

public class OsSystemProperty {

    public OsType getOsSystemPropertyType() {
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            return OsType.MAC;
        }

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            return OsType.WIN;
        }

        if (System.getProperty("os.name").toLowerCase().contains("lin")) {
            return OsType.LIN;
        }
        return null;
    }

    public String getOsSystemPropertyValue(OsType type){
        Properties prop = AppProperty.getInstance();
        String toReturn;
        switch (type){
            case MAC: toReturn = prop.getProperty("mac-cmd");
            break;

            case WIN: toReturn = prop.getProperty("win-cmd");
            break;

            case LIN: toReturn = prop.getProperty("lin-cmd");
            break;

            default: throw new IllegalArgumentException("Wrong doughnut type:" + type);
        }
        return toReturn;
    }

}
