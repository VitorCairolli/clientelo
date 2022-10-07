package br.com.alura.clientelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Order {

    private String category;
    private String product;
    private String client;

    private BigDecimal price;
    private int quantity;
    private BigDecimal totalPrice;
    private LocalDate date;

    public Order(String categoria, String produto, String cliente, BigDecimal preco, int quantidade, LocalDate data) {
        this.category = categoria;
        this.product = produto;
        this.client = cliente;
        this.price = preco;
        this.quantity = quantidade;
        this.date = data;
        this.totalPrice = price.multiply(BigDecimal.valueOf(quantity));
    }

    public String getCategory() {
        return category;
    }

    public String getProduct() {
        return product;
    }

    public String getClient() {
        return client;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public BigDecimal getTotalPrice(){return totalPrice;}

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "categoria='" + category + '\'' +
                ", produto='" + product + '\'' +
                ", cliente='" + client + '\'' +
                ", preco=" + price +
                ", quantidade=" + quantity +
                ", data=" + date +
                '}';
    }

}
