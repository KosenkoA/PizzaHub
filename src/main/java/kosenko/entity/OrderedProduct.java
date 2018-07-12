package kosenko.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
}
