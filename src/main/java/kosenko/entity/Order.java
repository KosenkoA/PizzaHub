package kosenko.entity;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order", schema = "ph")
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

    @Column(name = "closed")
    private boolean closed;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderedPizza> orderedPizzas;

    public Order() {
    }

    public Order(@Past Timestamp time, User user, boolean closed, List<OrderedPizza> orderedPizzas) {
        this.time = time;
        this.user = user;
        this.closed = closed;
        this.orderedPizzas = orderedPizzas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.user = user;
    }

    public List<OrderedPizza> getOrderedPizzas() {
        return orderedPizzas;
    }

    public void setOrderedPizzas(List<OrderedPizza> orderedPizzas) {
        this.orderedPizzas = orderedPizzas;
    }
}
