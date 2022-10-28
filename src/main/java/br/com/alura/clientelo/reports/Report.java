package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.models.Order;

import java.util.List;

public interface Report {
    public void logReport(List<Order> pedidos);

    public String title();
}