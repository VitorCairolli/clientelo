package br.com.alura.clientelo.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "productItem")
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Product product = new Product();

    @ManyToOne(optional = false)
    private Order targetOrder = new Order();

    @Column(nullable = false)
    private int quantity;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "discount", column = @Column(name = "discount_value")),
            @AttributeOverride(name = "type", column = @Column(name = "discount_type"))
    })
    private Discount discount = new Discount();

    ProductItem(){}

    public ProductItem(Product product, int quantity, Discount discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return targetOrder;
    }

    public void setOrder(Order order) {
        this.targetOrder = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalPrice(){
        BigDecimal total = product.getPrice().multiply(new BigDecimal(quantity));
        if(discount != null)
            return discount.applyDiscount(total);

        return total;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductItem that = (ProductItem) o;
        return quantity == that.quantity && Objects.equals(id, that.id) && product.equals(that.product) && Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, targetOrder, quantity, discount);
    }
}
