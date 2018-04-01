package Repository;

import Entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAllByAvailability();

    List<Pizza> findAllByNameAndAvailability();
}
