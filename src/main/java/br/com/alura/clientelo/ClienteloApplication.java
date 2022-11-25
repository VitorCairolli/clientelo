package br.com.alura.clientelo;

import br.com.alura.clientelo.controllers.ReportController;
import br.com.alura.clientelo.converters.CsvOrderConverter;
import br.com.alura.clientelo.repository.CategoryRepository;
import br.com.alura.clientelo.daos.OrderDao;
import br.com.alura.clientelo.models.*;
import br.com.alura.clientelo.reports.LoyalClientsReport;
import br.com.alura.clientelo.reports.MostSoldProductsReport;
import br.com.alura.clientelo.repository.ClientRepository;
import br.com.alura.clientelo.repository.ProductRepository;
import br.com.alura.clientelo.vo.MostSoldProductsVO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

@SpringBootApplication
public class ClienteloApplication implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    public ClienteloApplication(CategoryRepository categoryRepository, ClientRepository clientRepository, ProductRepository productRepository){
        this.categoryRepository = categoryRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        SpringApplication.run(ClienteloApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Order> orders = CsvOrderConverter.convert("orders.csv");

        OrderDao orderDao = new OrderDao();
        orderDao.createAll(orders);

        ReportController reportController = new ReportController();

        reportController.logReport(new LoyalClientsReport());

        reportController.logReport(new MostSoldProductsReport());

        System.out.println("All categories: " + categoryRepository.findAll());
        System.out.println("All clients: " + clientRepository.findAll());
        System.out.println("Clients order by expenses: " + clientRepository.findOrderedByMostExpended());
        System.out.println("All products: " + productRepository.findAll());
        System.out.println("Products ordered by most sold: " + productRepository.findOrderedByMostSoldProducts());
    }
}

