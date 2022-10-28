package br.com.alura.clientelo.reports;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class OrderReportOutput {

    private String category;
    private String product;
    private String client;
    private BigDecimal price;
    private BigDecimal quantity;
    private BigDecimal totalPrice;
    private LocalDate date;

    public OrderReportOutput(Builder builder) {
        this.category = builder.category;
        this.product = builder.product;
        this.client = builder.client;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.totalPrice = builder.totalPrice;
        this.date = builder.date;
    }

    @Override
    public String toString() {
        String string = "";
        if(product != null) string += "Name: " + product + "\n";
        if(category != null) string += "Category: " + category + "\n";
        if(client != null) string += "Client: " + client + "\n";
        if(price != null) string += "Price: " + price + "\n";
        if(quantity != null) string += "Quantity: " + quantity + "\n";
        if(totalPrice != null) string += "Total_Price: " + totalPrice + "\n";
        if(date != null) string += "Date: " + date + "\n";

        return string;

    }

    public static class Builder {

        private String category;
        private String product;
        private String client;
        private BigDecimal price;

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setProduct(String product) {
            this.product = product;
            return this;
        }

        public Builder setClient(String client) {
            this.client = client;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder setQuantity(BigDecimal quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setTotalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        private BigDecimal quantity;
        private BigDecimal totalPrice;
        private LocalDate date;

        public static Builder newInstance(){
            return new Builder();
        }

        public Builder(){}

        public OrderReportOutput build(){
            return new OrderReportOutput(this);
        }
    }
}
