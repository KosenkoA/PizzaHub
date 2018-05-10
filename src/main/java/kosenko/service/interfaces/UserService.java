package kosenko.service.interfaces;

import kosenko.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    void create(User user);

    void delete(long id);

    List<User> findAll();

    User update(User user);

    Optional<User> findById(long id);

    User findByEmail(String email);
}
