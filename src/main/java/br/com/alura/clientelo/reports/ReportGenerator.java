package br.com.alura.clientelo.reports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReportGenerator {

    private static final Logger logger = LoggerFactory.getLogger(ReportGenerator.class);


    static void logReport(String reportName, List<OrderReportOutput> reportOutput){
        String report = "#######" + reportName + "#######\n";
        for (OrderReportOutput output : reportOutput){
            report += output.toString() + "\n";
        }

        logger.info(report);
    }
}
