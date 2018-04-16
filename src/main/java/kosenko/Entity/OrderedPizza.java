package kosenko.Entity;

import javax.persistence.*;

@Entity
@Table(name = "ordered_pizza", schema = "ph")
public class OrderedPizza {
    @Id
    @SequenceGenerator(name = "orderdish-sequence_generator", sequenceName = "orderdish_sequence")
    @GeneratedValue(generator = "orderdish-sequence_generator", strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Pizza pizza;
}
