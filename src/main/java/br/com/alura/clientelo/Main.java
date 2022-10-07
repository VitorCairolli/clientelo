package br.com.alura.clientelo;

import br.com.alura.clientelo.controllers.ReportController;
import br.com.alura.clientelo.reports.DefaultReport;
import br.com.alura.clientelo.reports.MostValuableOrderedByCategoryReport;
import br.com.alura.clientelo.reports.OrderByCategoryReport;
import br.com.alura.clientelo.reports.TopThreeByQuantityReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.*;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
        
        ReportController reportController = new ReportController(pedidos);
        
        reportController.logReport(new TopThreeByQuantityReport());
        reportController.logReport(new OrderByCategoryReport());
        reportController.logReport(new MostValuableOrderedByCategoryReport());
        reportController.logReport(new DefaultReport());
    }
}

