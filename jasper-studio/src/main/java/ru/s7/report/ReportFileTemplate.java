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
        return getFullDirPath(pathJRxmlDir) + templateFileName;
    }

    String getReportDir() {
        return pathReportDir;
    }

    private String getFullDirPath(String pathDir){
        String delim = pathDir.indexOf("\\")>-1?"\\":"/";
        String lastDirPathSymbol = pathDir.substring(pathDir.length()-1).contains(delim)?"":delim;
        return pathDir + lastDirPathSymbol;
    }


    private String getDateSuffix(){
        SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd-HH-mm");
        return format.format(Calendar.getInstance().getTime());
    }

    String getFullReportFilePath() {
        return getFullDirPath(pathReportDir ) + templateFileName.replaceAll(".jrxml", "" )+ "_"+ getDateSuffix() + ".pdf";

    }

}
