package kosenko.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderproduct", schema = "ph")
public class OrderedProduct implements Serializable {
    @Id
    @SequenceGenerator(name = "orderproduct-sequence_generator", sequenceName = "orderproduct_sequence")
    @GeneratedValue(generator = "orderproduct-sequence_generator", strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
