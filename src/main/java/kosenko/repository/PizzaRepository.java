package kosenko.repository;

import kosenko.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAll();

    List<Pizza> findAllByAvailability(Boolean availability);

    List<Pizza> findAllByAvailabilityAndName(Boolean availability, String name);

    Optional<Pizza> deleteById(long id);
}