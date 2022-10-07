package br.com.alura.clientelo.controllers;

import br.com.alura.clientelo.Order;
import br.com.alura.clientelo.reports.Report;

import java.util.List;

public class ReportController {

    List<Order> pedidos;
    public ReportController(List<Order> pedidos){
        this.pedidos = pedidos;
    }

    public void logReport(Report report) {
        report.logReport(pedidos);
    }
}
