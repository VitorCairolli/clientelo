package br.com.alura.clientelo.models;

import br.com.alura.clientelo.converters.tools.BigDecimal2JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product implements Comparable<Product>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String name;

    @JsonDeserialize(using = BigDecimal2JsonDeserializer.class)
    BigDecimal price;

    String description;

    int quantityInStock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    Category category;

    Product(){}

    public Product(String name, BigDecimal price, String description, int quantityInStock, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantityInStock = quantityInStock;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantityInStock == product.quantityInStock && Objects.equals(id, product.id) && name.equals(product.name) && price.equals(product.price) && description.equals(product.description) && category.equals(product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, quantityInStock, category);
    }

    @Override
    public int compareTo(@NotNull Product comparedProduct) {
        return this.getCategory().getName().compareTo(comparedProduct.getCategory().getName());
    }
}
