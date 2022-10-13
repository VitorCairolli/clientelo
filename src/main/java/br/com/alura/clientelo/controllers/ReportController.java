package br.com.alura.clientelo.controllers;

import br.com.alura.clientelo.Order;
import br.com.alura.clientelo.reports.MostValuableOrderedByCategoryReport;
import br.com.alura.clientelo.reports.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReportController {

    List<Order> pedidos;
    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    public ReportController(List<Order> pedidos){
        this.pedidos = pedidos;
    }

    public void logReport(Report report) {
        logger.info("###### " + report.title() + " ######");
        report.logReport(pedidos);
    }
}
