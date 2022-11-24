package br.com.alura.clientelo;

import br.com.alura.clientelo.controllers.ReportController;
import br.com.alura.clientelo.converters.CsvOrderConverter;
import br.com.alura.clientelo.daos.CategoryRepository;
import br.com.alura.clientelo.daos.OrderDao;
import br.com.alura.clientelo.models.*;
import br.com.alura.clientelo.reports.LoyalClientsReport;
import br.com.alura.clientelo.reports.MostSoldProductsReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private final CategoryRepository repository;

    public Main(CategoryRepository repository){
        this.repository = repository;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Order> orders = CsvOrderConverter.convert("orders.csv");

        OrderDao orderDao = new OrderDao();
        orderDao.createAll(orders);

        ReportController reportController = new ReportController();

        reportController.logReport(new LoyalClientsReport());

        reportController.logReport(new MostSoldProductsReport());

        System.out.println("All categories: " + repository.findAll());
    }
}

