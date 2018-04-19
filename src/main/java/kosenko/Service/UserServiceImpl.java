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

        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public Optional<List<User>> findAll() {
        Optional<List<User>> usersToReturn = null;
        Optional<List<User>> userOptional = Optional.of(userRepository.findAll());

        if (userOptional.isPresent()) {
            usersToReturn = Optional.of(userRepository.findAll());
        }

        return usersToReturn;
    }

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Optional<User> findById(long id) {
        Optional<User> userToReturn = null;
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userToReturn = userRepository.findById(id);
        }

        return userToReturn;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> userToReturn = null;
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));

        if (userOptional.isPresent()) {
            userToReturn = Optional.ofNullable(userRepository.findByEmail(email));
        }

        return userToReturn;
    }

    @Override
    public List<User> findAllUser(Integer pageNumber) {
        List<User> usersToReturn = null;
        Optional<List<User>> userOptional = Optional.of(userRepository.findAll());

        if (userOptional.isPresent()) {
            usersToReturn = userRepository.findAll();
        }

        return usersToReturn;
    }
}
