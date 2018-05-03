package kosenko.Repository;

import kosenko.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

    void delete(Optional<Role> deletedRole);
}
