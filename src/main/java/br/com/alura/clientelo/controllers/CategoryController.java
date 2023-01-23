package br.com.alura.clientelo.controllers;

import br.com.alura.clientelo.dto.CategoryDTO;
import br.com.alura.clientelo.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> getCategories(@RequestParam int page,
                                                              @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);

        var categoriesPage = service.findAll(pageable);

        if (categoriesPage.isEmpty())
            return ResponseEntity.notFound().build();

        Page categoryDTOPage = categoriesPage.map(category -> CategoryDTO.from(category));

        return ResponseEntity.ok(categoryDTOPage);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long categoryId) {
        var category = service.findById(categoryId);

        if (category.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(CategoryDTO.from(category.get()));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO inputCategoryDTO, UriComponentsBuilder uriBuilder) {

        var category = service.create(inputCategoryDTO.toEntity());

        URI uri = uriBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).body(CategoryDTO.from(category));
    }
}
