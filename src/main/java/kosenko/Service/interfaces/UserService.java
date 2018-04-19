package kosenko.Service.interfaces;

import kosenko.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void create(User user);

    void delete(long id);

    Optional<List<User>> findAll();

    User update(User user);

    Optional<User> findById(long id);

    Optional<User> findByEmail(String email);

    List<User> findAllUser(Integer pageNumber);
}
