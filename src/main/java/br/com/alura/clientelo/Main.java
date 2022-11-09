package br.com.alura.clientelo;

import br.com.alura.clientelo.controllers.ReportController;
import br.com.alura.clientelo.converters.CsvOrderConverter;
import br.com.alura.clientelo.converters.JsonOrderConverter;
import br.com.alura.clientelo.daos.ClientDao;
import br.com.alura.clientelo.daos.ProductDao;
import br.com.alura.clientelo.models.*;
import br.com.alura.clientelo.reports.MostValuableByOrderCategoryReport;
import br.com.alura.clientelo.reports.OrderCategoryReport;
import br.com.alura.clientelo.reports.TopThreeOrdersByQuantityReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.*;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Order> orders = CsvOrderConverter.convert("orders.csv");

        ReportController reportController = new ReportController(orders);
        
        reportController.logReport(new TopThreeOrdersByQuantityReport());
        reportController.logReport(new OrderCategoryReport());
        reportController.logReport(new MostValuableByOrderCategoryReport());

        ProductDao productDao = new ProductDao();
        Product product = new Product("Ukulele",
                BigDecimal.TEN,
                "Mt fofo",
                23,
                new Category("INSTRUMENTO"));

        productDao.create(product);
        product.setCategory(new Category("PAO"));
        productDao.update(product);

        ClientDao clientDao = new ClientDao();
        Client client = (new Client("Sara",
                "saravana@gmail.com",
                new Address("Rua Sararara",
                        "13",
                        "sem comentarios")));

        clientDao.create(client);
        client.setName("Sara2");
        clientDao.update(client);
    }
}

