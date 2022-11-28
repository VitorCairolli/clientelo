package br.com.alura.clientelo.vo;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

public class MostSoldProductsVO {

    private final Long id;

    private final String name;

    private final BigDecimal price;

    private final Long timesSold;

    private final int quantityInStock;

    private final String description;

    public MostSoldProductsVO(Long id, String name, BigDecimal price, Long timeSold, int quantityInStock, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.timesSold = timeSold;
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

    public Long getTimesSold() {
        return timesSold;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }
}
