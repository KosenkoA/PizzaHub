package Entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @SequenceGenerator(name = "user-sequence_generator", sequenceName = "user_sequence")
    @GeneratedValue(generator = "user-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String secondName;

    public User() {
    }

    public User(long id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
