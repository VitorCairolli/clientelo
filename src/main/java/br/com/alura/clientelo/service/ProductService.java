package br.com.alura.clientelo.service;

import br.com.alura.clientelo.models.Category;
import br.com.alura.clientelo.models.Product;
import br.com.alura.clientelo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public Product create(Product newProduct){
        return repository.save(newProduct);
    }
}
