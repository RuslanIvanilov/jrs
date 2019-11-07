package ru.s7.report;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class ReportFileTemplate {
    private String pathJRxmlDir;
    private String templateFileName;
    private String pathReportDir;

    public ReportFileTemplate(String pathJRxmlDir, String templateFileName, String pathReportDir) {
        this.pathJRxmlDir = pathJRxmlDir;
        this.templateFileName = templateFileName;
        this.pathReportDir = pathReportDir;
    }

    String getTemplateJRxmlFilePath() {
        return pathJRxmlDir + templateFileName;
    }

    String getReportDir() {
        return pathReportDir;
    }
    /*
    private String getDateSuffix(){
        Calendar cal = new Calendar() {
        }
        return
    }
    */

    private String getDateSuffix(){
        SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd-HH-mm");
        return format.format(Calendar.getInstance().getTime());
    }

    String getFullReportFilePath() {

        System.out.println( "Calendar: " + getDateSuffix() );
        System.out.println("pathReportDir [" + pathReportDir + "]");
        System.out.println("file [" + pathReportDir + templateFileName.replaceAll(".jrxml", "" )+ "_"+ getDateSuffix() + ".pdf" + "]");

        String delim = pathReportDir.indexOf("\\")>-1?"\\":"/";
        String lastDirPathSymbol = pathReportDir.substring(pathReportDir.length()-1).contains(delim)?"":delim;

        return pathReportDir + lastDirPathSymbol + templateFileName.replaceAll(".jrxml", "" )+ "_"+ getDateSuffix() + ".pdf";

    }

}
