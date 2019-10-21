package ru.s7.main_frame.oscmd;

import ru.s7.main_frame.oscmd.OsCmd;

import java.io.IOException;
import java.util.Properties;

public class WinOs implements OsCmd {
    @Override
    public void execute(String stringCmd) throws IOException {

        String delimiter = ";";
        String[] execCmd  = stringCmd.split(delimiter);
        Runtime.getRuntime().exec(execCmd);
    }
}
