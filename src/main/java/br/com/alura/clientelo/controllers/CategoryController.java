package br.com.alura.clientelo.controllers;

import br.com.alura.clientelo.dto.CategoryDTO;
import br.com.alura.clientelo.dto.OutputAllCategoryDTO;
import br.com.alura.clientelo.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<OutputAllCategoryDTO> getCategories() {
        var categories = service.findAll();

        if (categories.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(OutputAllCategoryDTO.from(categories));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long categoryId) {
        var category = service.findById(categoryId);

        if (category.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(CategoryDTO.from(category.get()));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO inputCategoryDTO) {

        var plateau = service.create(inputCategoryDTO.toEntity());

        return ResponseEntity.ok(CategoryDTO.from(plateau));
    }
}
