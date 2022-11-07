package br.com.alura.clientelo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category")
public class Category implements Comparable<Category> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "inactive", nullable = false)
    boolean inactive;

    Category(){}

    public Category(String name) {
        this.name = name;
        this.inactive = false;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(@org.jetbrains.annotations.NotNull Category comparedCategory) {
        return this.getName().compareTo(comparedCategory.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return inactive == category.inactive && Objects.equals(id, category.id) && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, inactive);
    }
}
