package br.com.alura.clientelo.models;

import java.math.BigDecimal;

public enum DiscountType {

    PERCENTAGE {
        @Override
        BigDecimal applyDiscount(BigDecimal total, BigDecimal discount) {
            return discount.multiply(total);
        }
    }, FIXED{
        @Override
        BigDecimal applyDiscount(BigDecimal total, BigDecimal discount) {
            return total.subtract(discount);
        }
    };

    abstract BigDecimal applyDiscount(BigDecimal total, BigDecimal discount);
}
