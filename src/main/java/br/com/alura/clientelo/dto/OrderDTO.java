package br.com.alura.clientelo.dto;

import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.models.ProductItem;

import java.time.LocalDate;
import java.util.List;

public record OrderDTO(Long id, List<ProductItemDTO> productItems, ClientDTO client, LocalDate date) {

    public Order toEntity() {
        List<ProductItem> productItemList = productItems.stream()
                .map(ProductItemDTO::toEntity)
                .toList();
        Order order = new Order(productItemList,
                client.toEntity(),
                date);
        order.getProductItems().forEach(productItem -> productItem.setOrder(order));
        return order;
    }

    public static OrderDTO from(Order order){
        return new OrderDTO(order.getId(),
                order.getProductItems().stream()
                        .map(ProductItemDTO::from)
                        .toList(),
                ClientDTO.from(order.getClient()),
                order.getDate());
    }
}
