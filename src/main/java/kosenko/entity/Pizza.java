package kosenko.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "pizza", schema = "ph")
public class Pizza implements Serializable {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Pizza() {
    }

    public Pizza(@Size(min = 3, max = 500) String name, @Size(min = 3, max = 500) String description, int weight, @Max(5000) @Min(0) int calories, @Min(0) String preparingtime, boolean availability) {
        this.name = name;
        this.description = description;
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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
