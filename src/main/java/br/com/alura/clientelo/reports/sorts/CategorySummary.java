package br.com.alura.clientelo.reports.sorts;

import br.com.alura.clientelo.models.Client;
import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.models.ProductItem;

import java.math.BigDecimal;

public class CategorySummary {
    private BigDecimal price;
    private int quantity;

    public CategorySummary(ProductItem productItem) {
        this.price = productItem.getTotalPrice();
        this.quantity = productItem.getQuantity();
    }

    public void addOrderValues(ProductItem productItem){
        price = price.add(productItem.getTotalPrice());
        quantity += productItem.getQuantity();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
