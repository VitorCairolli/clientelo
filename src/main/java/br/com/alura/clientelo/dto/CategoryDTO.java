package br.com.alura.clientelo.dto;

import br.com.alura.clientelo.models.Category;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CategoryDTO(Long id, String name, boolean inactive) {

    public Category toEntity() {
        return new Category(name);
    }

    public static CategoryDTO from(Category category){
        return new CategoryDTO(category.getId(),
                category.getName(),
                category.isInactive());
    }
}
