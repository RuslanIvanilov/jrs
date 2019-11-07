package ru.s7.report;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import net.sf.jasperreports.engine.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReportCreator {

    public ReportCreator(ReportFileTemplate reportFileTemplate) throws JRException, IOException {
        JasperReport jasperReport = JasperCompileManager.compileReport( reportFileTemplate.getTemplateJRxmlFilePath() );
        //"C:/jasperreport/StyledTextReport/StyledTextReport.jrxml"

        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();

        // DataSource
        // This is simple example, no database.
        // then using empty datasource.
        JRDataSource dataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                parameters, dataSource);

        // Make sure the output directory exists.
        File outDir = new File( reportFileTemplate.getReportDir() );
        outDir.mkdirs();

        // Export to PDF.
        JasperExportManager.exportReportToPdfFile(jasperPrint, reportFileTemplate.getFullReportFilePath());

        System.out.println(" Finish ");
    }

}
