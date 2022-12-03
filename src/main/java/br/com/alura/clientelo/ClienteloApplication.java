package br.com.alura.clientelo;

import br.com.alura.clientelo.controllers.ReportController;
import br.com.alura.clientelo.converters.CsvOrderConverter;
import br.com.alura.clientelo.repository.CategoryRepository;
import br.com.alura.clientelo.daos.OrderDao;
import br.com.alura.clientelo.models.*;
import br.com.alura.clientelo.reports.LoyalClientsReport;
import br.com.alura.clientelo.reports.MostSoldProductsReport;
import br.com.alura.clientelo.repository.ClientRepository;
import br.com.alura.clientelo.repository.OrderRepository;
import br.com.alura.clientelo.repository.ProductRepository;
import br.com.alura.clientelo.vo.MostSoldProductsVO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

@SpringBootApplication
public class ClienteloApplication{
    private final CategoryRepository categoryRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public ClienteloApplication(CategoryRepository categoryRepository, ClientRepository clientRepository, ProductRepository productRepository, OrderRepository orderRepository){
        this.categoryRepository = categoryRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        SpringApplication.run(ClienteloApplication.class, args);
    }
}

