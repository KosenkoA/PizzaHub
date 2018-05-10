package kosenko.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "user", schema = "ph")
public class User {
    @Id
    @SequenceGenerator(name = "user-sequence_generator", sequenceName = "user_sequence")
    @GeneratedValue(generator = "user-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id;
    @Email
    @Size(min = 5, max = 50)
    private String email;
    @Size(min = 5, max = 100)
    private String password;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(
            schema = "ph",
            name = "userrole",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles;

    public User() {
    }

    public User(@Email @Size(min = 5, max = 50) String email, @Size(min = 5, max = 100) String password, String name, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getRoles(), user.getRoles());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
