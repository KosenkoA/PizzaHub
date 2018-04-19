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
    public List<User> findAll() {
        List<User> usersToReturn;
        List<User> userOptional = Optional.ofNullable(userRepository.findAll()).orElse(null);

        usersToReturn = userOptional;

        return usersToReturn;
    }

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Optional<User> findById(long id) {
        Optional<User> userToReturn;
        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(id)).orElse(null);

        userToReturn = userOptional;

        return userToReturn;
    }

    @Override
    public User findByEmail(String email) {
        User userToReturn;
        User userOptional = Optional.ofNullable(userRepository.findByEmail(email)).orElse(null);

        userToReturn = userOptional;

        return userToReturn;
    }


}
