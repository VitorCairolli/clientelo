package br.com.alura.clientelo.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Order {

    private String category;
    private String product;
    private Client client;
    private BigDecimal price;
    private int quantity;
    private LocalDate date;

    public Order(String categoria, String produto, Client cliente, BigDecimal preco, int quantidade, LocalDate data) {
        this.category = categoria;
        this.product = produto;
        this.client = cliente;
        this.price = preco;
        this.quantity = quantidade;
        this.date = data;
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

    public LocalDate getDate() {
        return date;
    }
    
    public BigDecimal getTotalPrice(){
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public boolean isMoreExpensiveThan(Order otherOrder){
        return this.getTotalPrice().compareTo(otherOrder.getTotalPrice()) > 0;
    }

    public boolean isLessExpensiveThan(Order otherOrder){
        return this.getTotalPrice().compareTo(otherOrder.getTotalPrice()) < 0;
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
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, product, client, price, quantity, date);
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
