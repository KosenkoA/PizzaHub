package kosenko.Service.interfaces;

import kosenko.Entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role create(Role role);

    Optional<Role> delete(long id);

    List<Role> findAll();

    Role update(Role role);

    Optional<Role> findById(long id);

    Role findByName(String name);
}
