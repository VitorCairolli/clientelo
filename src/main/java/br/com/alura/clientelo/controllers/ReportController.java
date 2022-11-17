package br.com.alura.clientelo.controllers;

import br.com.alura.clientelo.reports.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportController {

    public ReportController(){
    }

    public void logReport(Report report) {

            report.logReport();
    }
}
