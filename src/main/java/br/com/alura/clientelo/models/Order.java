package br.com.alura.clientelo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( nullable = false)
    @OneToMany(mappedBy = "targetOrder", cascade = CascadeType.ALL)
    private List<ProductItem> productItems;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "create_date", nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    Order(){};

    public Order(List<ProductItem> productItems, Client client, LocalDate date) {
        this.productItems = productItems;
        this.client = client;
        this.date = date;
    }

    public Order(ProductItem productItems, Client client, LocalDate date) {
        this.productItems = new ArrayList<>();
        this.productItems.add(productItems);
        this.client = client;
        this.date = date;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotalPrice(){
        return productItems.stream()
                .map(item -> item.getTotalPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int getTotalQuantity(){
        return productItems.stream()
                .map(item -> item.getQuantity())
                .reduce(0, (subtotal, quantity) -> subtotal + quantity);
    }

    public boolean hasProductOfCategory(String category){
        for(ProductItem productItem : productItems){
            if(productItem.getProduct().getCategory().getName().equals(category))
                return true;
        }

        return false;
    }

    public boolean isMoreExpensiveThan(Order otherOrder){
        return this.getTotalPrice().compareTo(otherOrder.getTotalPrice()) > 0;
    }

    public boolean isLessExpensiveThan(Order otherOrder){
        return this.getTotalPrice().compareTo(otherOrder.getTotalPrice()) < 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productItems=" + productItems +
                ", client=" + client +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && productItems.equals(order.productItems) && client.equals(order.client) && Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productItems, client, date);
    }
}
