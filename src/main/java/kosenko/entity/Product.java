package kosenko.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "product", schema = "ph")
public class Product implements Serializable {
    @Id
    @SequenceGenerator(name = "user-sequence_generator", sequenceName = "user_sequence")
    @GeneratedValue(generator = "user-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, max = 500)
    private String name;

    @Size(min = 3, max = 500)
    private String description;

    private int weight;

    @Max(5000)
    @Min(0)
    private int calories;

    @Min(0)
    private String preparingtime;

    private boolean availability;

    private String picture;
}
