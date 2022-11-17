package br.com.alura.clientelo.vo;

import java.math.BigDecimal;

public class MostSoldProductsVO {

    private final long id;

    private final String name;

    private final BigDecimal price;

    private final long timeSold;

    private final int quantityInStock;

    private final String description;

    public MostSoldProductsVO(long id, String name, BigDecimal price, long timeSold, int quantityInStock, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.timeSold = timeSold;
        this.quantityInStock = quantityInStock;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getTimeSold() {
        return timeSold;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }
}
