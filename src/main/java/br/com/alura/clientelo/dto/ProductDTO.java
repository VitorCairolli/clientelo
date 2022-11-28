package br.com.alura.clientelo.dto;

import br.com.alura.clientelo.models.Category;
import br.com.alura.clientelo.models.Product;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductDTO(Long id, String name, BigDecimal price, String description, int quantityInStock, CategoryDTO category) {

    public Product toEntity() {
        return new Product(name,
                price,
                description,
                quantityInStock,
                category.toEntity());
    }

    public static ProductDTO from(Product product){
        return new ProductDTO(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getQuantityInStock(),
                CategoryDTO.from(product.getCategory()));
    }
}
