package kosenko.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderpizza", schema = "ph")
public class OrderedPizza {
    @Id
    @SequenceGenerator(name = "orderpizza-sequence_generator", sequenceName = "orderpizza_sequence")
    @GeneratedValue(generator = "orderpizza-sequence_generator", strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;
}
