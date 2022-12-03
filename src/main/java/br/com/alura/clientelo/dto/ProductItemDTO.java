package br.com.alura.clientelo.dto;

import br.com.alura.clientelo.models.*;

public record ProductItemDTO(Long id, Long orderId, ProductDTO product, int quantity, Discount discount) {

    public ProductItem toEntity() {
        return new ProductItem(product.toEntity(),
                quantity,
                discount);
    }

    public static ProductItemDTO from(ProductItem productItem){
        return new ProductItemDTO(productItem.getId(),
                productItem.getOrder().getId(),
                ProductDTO.from(productItem.getProduct()),
                productItem.getQuantity(),
                productItem.getDiscount());
    }
}
