package kosenko.Entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pizza", schema = "ph")
public class Pizza {
    @Id
    @SequenceGenerator(name = "user-sequence_generator", sequenceName = "user_sequence")
    @GeneratedValue(generator = "user-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, max = 500)
    private String name;

    @Size(min = 3, max = 500)
    private String Description;

    private int weight;

    @Max(5000)
    @Min(0)
    private int calories;

    @Min(0)
    private String preparingtime;

    private boolean availability;

    public Pizza() {
    }

    public Pizza(@Size(min = 3, max = 500) String name, @Size(min = 3, max = 500) String description, int weight, @Max(5000) @Min(0) int calories, @Min(0) String preparingtime, boolean availability) {
        this.name = name;
        Description = description;
        this.weight = weight;
        this.calories = calories;
        this.preparingtime = preparingtime;
        this.availability = availability;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getPreparingtime() {
        return preparingtime;
    }

    public void setPreparingtime(String preparingtime) {
        this.preparingtime = preparingtime;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
