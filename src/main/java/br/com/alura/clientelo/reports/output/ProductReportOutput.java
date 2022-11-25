package br.com.alura.clientelo.reports.output;

import java.math.BigDecimal;

public final class ProductReportOutput implements Output {

    private Long product_id;
    private String category;
    private BigDecimal price;
    private String name;

    private Long timesSold;
    private BigDecimal quantityInStock;
    private String description;

    public ProductReportOutput(ProductReportOutput.Builder builder) {
        this.product_id = builder.product_id;
        this.category = builder.category;
        this.price = builder.price;
        this.name = builder.name;
        this.quantityInStock = builder.quantityInStock;
        this.description = builder.description;
        this.timesSold = builder.timesSold;
    }

    @Override
    public String toString() {
        String string = "";
        if (product_id != null) string += "Product_Id: " + product_id + "\n";
        if (name != null) string += "Name: " + name + "\n";
        if (category != null) string += "Category: " + category + "\n";
        if (timesSold != null) string += "Times_Sold: " + timesSold + "\n";
        if (description != null) string += "Description: " + description + "\n";
        if (quantityInStock != null) string += "Quantity_In_Stock: " + quantityInStock + "\n";
        if (price != null) string += "Price: " + price + "\n";

        return string;
    }

    public static class Builder {

        private Long product_id;
        private String category;
        private BigDecimal price;
        private String name;
        private BigDecimal quantityInStock;
        private String description;
        private Long timesSold;

        public Builder setTimesSold(Long timesSold) {
            this.timesSold = timesSold;
            return this;
        }

        public Builder setProductId(Long id) {
            this.product_id = id;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setQuantityInStock(BigDecimal quantity) {
            this.quantityInStock = quantity;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public static Builder newInstance() {
            return new ProductReportOutput.Builder();
        }

        public Builder() {
        }

        public ProductReportOutput build() {
            return new ProductReportOutput(this);
        }
    }
}
