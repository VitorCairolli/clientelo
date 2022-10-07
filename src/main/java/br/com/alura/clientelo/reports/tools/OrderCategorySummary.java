package br.com.alura.clientelo.reports.tools;

import br.com.alura.clientelo.reports.TopThreeByQuantityReport;

import java.math.BigDecimal;

public class OrderCategorySummary {
    private String category;
    private int quantity;
    private BigDecimal totalValue;

    public OrderCategorySummary(String category, int quantity, BigDecimal totalValue) {
        this.category = category;
        this.quantity = quantity;
        this.totalValue = totalValue;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalValue;
    }

    public void addValues(int quantity, BigDecimal price) {
        quantity += quantity;
        totalValue = price.add(totalValue);
    }
}
