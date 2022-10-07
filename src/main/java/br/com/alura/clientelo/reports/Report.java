package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface Report {
    public void logReport(List<Pedido> pedidos);
}
