package ru.s7.main_frame.oscmd;

import java.io.IOException;

public class OsCmdFactory {

    public void executeOsCmd(OsSystemProperty prop, OsType type) throws IOException {
        switch (type) {
            case MAC:
                new MacOs().execute(prop.getOsSystemPropertyValue(type));
                break;
            case WIN:
                new WinOs().execute(prop.getOsSystemPropertyValue(type));
                break;
            case LIN:
                new LinOs().execute(prop.getOsSystemPropertyValue(type));
                break;
            default:
                throw new IllegalArgumentException("Wrong Os type:" + type);
        }
    }
}
