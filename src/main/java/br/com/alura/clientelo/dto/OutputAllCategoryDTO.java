package br.com.alura.clientelo.dto;

import br.com.alura.clientelo.models.Category;

import java.util.List;

public record OutputAllCategoryDTO (List<CategoryDTO> categories){

    public static OutputAllCategoryDTO from (List<Category> categories){
        return new OutputAllCategoryDTO(categories.stream().map(category -> CategoryDTO.from(category)).toList());
    }
}
