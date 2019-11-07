package ru.s7.report;

import java.util.Calendar;
import java.util.Date;

public class ReportFileTemplate {
    String pathJRxmlDir;
    String templateFileName;
    String pathReportDir;

    public ReportFileTemplate(String pathJRxmlDir, String templateFileName, String pathReportDir) {
        this.pathJRxmlDir = pathJRxmlDir;
        this.templateFileName = templateFileName;
        this.pathReportDir = pathReportDir;
    }

    public String getTemplateJRxmlFilePath() {
        return pathJRxmlDir + templateFileName;
    }

    public String getReportDir() {
        return pathReportDir;
    }
    /*
    private String getDateSuffix(){
        Calendar cal = new Calendar() {
        }
        return
    }
    */

    public String getFullReportFilePath() {

        System.out.println("Calendar: " + Calendar.getInstance().getTime());

        return pathReportDir + templateFileName.replaceAll(".jrxml", "" )+ "_"+ Calendar.getInstance().getTime().toGMTString() + ".pdf";

    }

}
