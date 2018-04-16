package kosenko.DAO;

import kosenko.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserDAO {
    Collection<User> getAllUsers();

    User getUserById(long id);

    void removeUserById(int id);

    void updateUser(User user);

    void insertUserToDB(User student);
}
