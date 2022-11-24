package br.com.alura.clientelo.controllers;

import br.com.alura.clientelo.reports.Report;

public class ReportController {

    public ReportController(){
    }

    public void logReport(Report report) {

            report.logReport();
    }
}
