package kosenko.Repository;

import kosenko.Entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    //List<Pizza> findAllByAvailability();

    //List<Pizza> findAllByAvailabilityAndName();

    List<Pizza> findAll();
    //List<Pizza> findAllByAvailability();
}
