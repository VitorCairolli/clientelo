package br.com.alura.clientelo.controllers;

import br.com.alura.clientelo.Pedido;
import br.com.alura.clientelo.reports.Report;

import java.util.List;

public class ReportController {

    List<Pedido> pedidos;
    public ReportController(List<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    public void logReport(Report report) {
        report.logReport(pedidos);
    }
}
