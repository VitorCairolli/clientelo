package br.com.alura.clientelo.controllers;

import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.reports.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReportController {

    List<Order> orders;
    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    public ReportController(List<Order> pedidos){
        this.orders = pedidos;
    }

    public void logReport(Report report) {
        logger.info("###### " + report.title() + " ######\n");

        if(orders == null)
            logger.info("!!!!!FOI PASSADO UMA LISTA NULA!!!!!\n");

        else
            report.logReport(orders);
    }
}
