package br.com.alura.clientelo.service;

import br.com.alura.clientelo.models.Category;
import br.com.alura.clientelo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    public Category create(Category newCategory){
        return repository.save(newCategory);
    }
}
