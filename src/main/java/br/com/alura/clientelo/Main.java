package br.com.alura.clientelo;

import br.com.alura.clientelo.controllers.ReportController;
import br.com.alura.clientelo.converters.CsvOrderConverter;
import br.com.alura.clientelo.converters.JsonOrderConverter;
import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.reports.DefaultReport;
import br.com.alura.clientelo.reports.MostValuableByOrderCategoryReport;
import br.com.alura.clientelo.reports.OrderCategoryReport;
import br.com.alura.clientelo.reports.TopThreeOrdersByQuantityReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Order> orders = JsonOrderConverter.convert("orders.json");

        ReportController reportController = new ReportController(orders);
        
        reportController.logReport(new TopThreeOrdersByQuantityReport());
        reportController.logReport(new OrderCategoryReport());
        reportController.logReport(new MostValuableByOrderCategoryReport());
        reportController.logReport(new DefaultReport());

        EntityManagerFactory a = Persistence.createEntityManagerFactory("clientelo");
        EntityManager em = a.createEntityManager();

        em.getTransaction().begin();
        em.persist(orders.get(0));
        em.getTransaction().commit();
    }
}

