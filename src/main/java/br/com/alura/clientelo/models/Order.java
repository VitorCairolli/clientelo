package br.com.alura.clientelo.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Order {

    private String category;
    private String product;
    private Client client;
    private BigDecimal price;
    private int quantity;
    private BigDecimal totalPrice;
    private LocalDate date;

    public Order(String categoria, String produto, Client cliente, BigDecimal preco, int quantidade, LocalDate data) {
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

    public Client getClient() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity &&
                Objects.equals(category, order.category) &&
                Objects.equals(product, order.product) &&
                Objects.equals(client, order.client) &&
                Objects.equals(price, order.price) &&
                Objects.equals(totalPrice, order.totalPrice) &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, product, client, price, quantity, totalPrice, date);
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
