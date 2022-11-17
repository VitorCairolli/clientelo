package br.com.alura.clientelo;

import br.com.alura.clientelo.controllers.ReportController;
import br.com.alura.clientelo.converters.CsvOrderConverter;
import br.com.alura.clientelo.daos.ClientDao;
import br.com.alura.clientelo.daos.OrderDao;
import br.com.alura.clientelo.models.*;
import br.com.alura.clientelo.reports.LoyalClientsReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Order> orders = CsvOrderConverter.convert("orders.csv");

        OrderDao orderDao = new OrderDao();
        orderDao.createAll(orders);

        ReportController reportController = new ReportController();

        reportController.logReport(new LoyalClientsReport());
//
//        ClientDao clientDao = new ClientDao();
//        clientDao.top3MostLoyalClientReport();
    }
}

