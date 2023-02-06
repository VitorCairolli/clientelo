package br.com.alura.clientelo.service;

import br.com.alura.clientelo.models.Category;
import br.com.alura.clientelo.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    public Page<Category> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    public Category create(Category newCategory){
        Optional<Category> category = repository.findByName(newCategory.getName());
        if(category.isPresent()) return category.get();

        return repository.save(newCategory);
    }
}
