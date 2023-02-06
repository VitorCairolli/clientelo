package br.com.alura.clientelo;

import br.com.alura.clientelo.repository.CategoryRepository;
import br.com.alura.clientelo.repository.ClientRepository;
import br.com.alura.clientelo.repository.OrderRepository;
import br.com.alura.clientelo.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
//@EnableSpringDataWebSupport
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

