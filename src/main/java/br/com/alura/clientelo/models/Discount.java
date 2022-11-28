package br.com.alura.clientelo.models;

import br.com.alura.clientelo.converters.tools.BigDecimal2JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class Discount {
    @Enumerated(EnumType.STRING)
    DiscountType type;

    @JsonDeserialize(using = BigDecimal2JsonDeserializer.class)
    BigDecimal discount;

    Discount(){}

    public Discount(DiscountType type, BigDecimal discount) {
        this.type = type;
        this.discount = discount;
    }

    public DiscountType getType() {
        return type;
    }

    public void setType(DiscountType type) {
        this.type = type;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal applyDiscount(BigDecimal total){
        return type.applyDiscount(total, discount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return type == discount1.type && discount.equals(discount1.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, discount);
    }
}
