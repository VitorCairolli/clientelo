package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.models.ProductItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public final class OrderReportOutput {

    private Long order_id;
    private String category;
    private List<ProductItem> productItems;
    private String client;
    private BigDecimal totalPrice;
    private LocalDate date;
    private BigDecimal quantity;

    public OrderReportOutput(Builder builder) {
        this.order_id = builder.order_id;
        this.category = builder.category;
        this.productItems = builder.productItems;
        this.client = builder.client;
        this.totalPrice = builder.totalPrice;
        this.date = builder.date;
        this.quantity = builder.quantity;
    }

    @Override
    public String toString() {
        String string = "";
        if(order_id != null) string += "OrderId: " + order_id + "\n";
        if(productItems != null) string += "ProductItems: " + productItems + "\n";
        if(category != null) string += "Category: " + category + "\n";
        if(client != null) string += "Client: " + client + "\n";
        if(quantity != null) string += "Quantity " + quantity + "\n";
        if(totalPrice != null) string += "Total_Price: " + totalPrice + "\n";
        if(date != null) string += "Date: " + date + "\n";

        return string;

    }

    public static class Builder {

        private Long order_id;
        private String category;
        private List<ProductItem> productItems;
        private String client;
        private BigDecimal quantity;
        private BigDecimal totalPrice;
        private LocalDate date;

        public Builder setOrderId(Long id) {
            this.order_id = order_id;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setProductItem(List<ProductItem> productItems) {
            this.productItems = productItems;
            return this;
        }

        public Builder setClient(String client) {
            this.client = client;
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

        public static Builder newInstance(){
            return new Builder();
        }

        public Builder(){}

        public OrderReportOutput build(){
            return new OrderReportOutput(this);
        }
    }
}
