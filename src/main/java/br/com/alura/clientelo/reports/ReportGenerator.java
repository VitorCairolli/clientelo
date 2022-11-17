package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.reports.output.OrderReportOutput;
import br.com.alura.clientelo.reports.output.Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReportGenerator {

    private static final Logger logger = LoggerFactory.getLogger(ReportGenerator.class);

    static void logReport(String reportName, List<Output> reportOutput){
        String report = "#######" + reportName + "#######\n";
        for (Output output : reportOutput){
            report += output.toString() + "\n";
        }

        logger.info(report);
    }
}
