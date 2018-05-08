package kosenko.Service.interfaces;

import kosenko.Entity.Pizza;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface PizzaService {
    Pizza create(Pizza pizza);

    Optional<Pizza> findById(long id);

    List<Pizza> findByAvailableAndNameContaining(String name);

    Optional<Pizza> delete(long id);

    List<Pizza> findAll();

    List<Pizza> findAllAvailable();

    Pizza update(Pizza pizza);
}
