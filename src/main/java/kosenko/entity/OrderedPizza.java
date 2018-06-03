package kosenko.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderpizza", schema = "ph")
public class OrderedPizza implements Serializable {
    @Id
    @SequenceGenerator(name = "orderpizza-sequence_generator", sequenceName = "orderpizza_sequence")
    @GeneratedValue(generator = "orderpizza-sequence_generator", strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;
}
