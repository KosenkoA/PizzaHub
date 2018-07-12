package kosenko.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "order", schema = "ph")
public class Order implements Serializable {
    @Id
    @SequenceGenerator(name = "order-sequence_generator", sequenceName = "order_sequence")
    @GeneratedValue(generator = "order-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id;

    @Past
    private Timestamp time;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "closed")
    private boolean closed;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderedProduct> orderedProducts;


}
