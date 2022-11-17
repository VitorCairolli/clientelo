package br.com.alura.clientelo.vo;

import java.math.BigDecimal;

public class ClientTotalPriceAndOrders {

    private String name;

    private BigDecimal totalPrice;

    private Long totalOrders;

    public ClientTotalPriceAndOrders(String name, BigDecimal totalPrice, Long totalOrders) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.totalOrders = totalOrders;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Long getTotalOrders() {
        return totalOrders;
    }
}
