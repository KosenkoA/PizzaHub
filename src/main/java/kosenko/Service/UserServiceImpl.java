package kosenko.Service;

import kosenko.Entity.User;
import kosenko.Repository.UserRepository;
import kosenko.Service.interfaces.UserService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        Optional<User> userOptional = userRepository.findById(id);

        userOptional.ifPresent(user -> userRepository.deleteById(id));
    }

    @Override
    public List<User> findAll() {
        List<User> usersToReturn;

        usersToReturn = Optional.ofNullable(userRepository.findAll()).orElse(null);

        return usersToReturn;
    }

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Optional<User> findById(long id) {
        Optional<User> userToReturn;

        userToReturn = Optional.ofNullable(userRepository.findById(id)).orElse(null);

        return userToReturn;
    }

    @Override
    public User findByEmail(String email) {
        User userToReturn;

        userToReturn = Optional.ofNullable(userRepository.findByEmail(email)).orElse(null);

        return userToReturn;
    }


}
