package ru.s7.main_frame.oscmd;

import java.io.IOException;
import java.util.Properties;

public interface OsCmd {
   void execute(String stringCmd) throws IOException;

}
