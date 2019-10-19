package ru.s7.main_frame.oscmd;

import java.io.IOException;
import java.util.Properties;

public class LinOs implements OsCmd {
    @Override
    public void execute(String stringCmd) throws IOException {
        Runtime.getRuntime().exec(stringCmd);
    }
}
