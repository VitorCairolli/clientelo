package br.com.alura.clientelo.dto;

import br.com.alura.clientelo.models.Category;
import br.com.alura.clientelo.models.Product;

import java.util.List;

public record OutputAllProductDTO(List<ProductDTO> products) {

    public static OutputAllProductDTO from (List<Product> products){
        return new OutputAllProductDTO(products.stream().map(product -> ProductDTO.from(product)).toList());
    }
}
