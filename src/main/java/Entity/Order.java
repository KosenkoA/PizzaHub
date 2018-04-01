package Entity;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @SequenceGenerator(name = "order-sequence_generator", sequenceName = "order_sequence")
    @GeneratedValue(generator = "order-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id;

    @Past
    private Timestamp time;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderedPizza> orderedPizzas;
}
