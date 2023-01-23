package br.com.alura.clientelo.service;

import br.com.alura.clientelo.models.Category;
import br.com.alura.clientelo.models.Product;
import br.com.alura.clientelo.repository.CategoryRepository;
import br.com.alura.clientelo.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository, CategoryRepository categoryRepository){
        this.productRepository = repository;
        this.categoryRepository = categoryRepository;
    }

    public Page<Product> findAll(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(Product newProduct){

        Optional<Category> category = categoryRepository.findByName(newProduct.getCategory().getName());

        category.ifPresent(newProduct::setCategory);

        return productRepository.save(newProduct);
    }
}
