package br.com.alura.clientelo.reports.sorts;

import br.com.alura.clientelo.models.Client;
import br.com.alura.clientelo.models.Order;

import java.math.BigDecimal;

public class CategorySummary {
    private BigDecimal price;
    private int quantity;

    public CategorySummary(Order order) {
        this.price = order.getTotalPrice();
        this.quantity = order.getQuantity();
    }

    public void addOrderValues(Order order){
        price = price.add(order.getTotalPrice());
        quantity += order.getQuantity();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
