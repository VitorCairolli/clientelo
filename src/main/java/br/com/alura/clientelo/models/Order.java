package br.com.alura.clientelo.models;

import br.com.alura.clientelo.converters.tools.BigDecimal2JsonDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Category category;

    @Column(name = "product", nullable = false)
    private String product;

    @ManyToOne
    @Column(name = "client", nullable = false)
    @JoinColumn(name = "id")
    private Client client;

    @Column(name = "price", nullable = false)
    @JsonDeserialize(using = BigDecimal2JsonDeserializer.class)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    Order(){};

    public Order(Category category, String product, Client client, BigDecimal price, int quantity, LocalDate date) {
        this.category = category;
        this.product = product;
        this.client = client;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
    }

    public Category getCategory() {
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
