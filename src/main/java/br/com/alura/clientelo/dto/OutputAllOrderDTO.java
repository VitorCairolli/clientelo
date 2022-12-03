package br.com.alura.clientelo.dto;

import br.com.alura.clientelo.models.Category;
import br.com.alura.clientelo.models.Order;

import java.util.List;

public record OutputAllOrderDTO(List<OrderDTO> orders) {

    public static OutputAllOrderDTO from (List<Order> orders){
        return new OutputAllOrderDTO(orders.stream().map(order -> OrderDTO.from(order)).toList());
    }
}
