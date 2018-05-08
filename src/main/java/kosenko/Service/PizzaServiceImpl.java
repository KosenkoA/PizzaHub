package kosenko.Service;

import kosenko.Entity.Pizza;
import kosenko.Repository.PizzaRepository;
import kosenko.Service.interfaces.PizzaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PizzaServiceImpl implements PizzaService {
    @Resource
    private PizzaRepository pizzaRepository;

    @Override
    @Transactional
    public Pizza create(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @Override
    @Transactional
    public Optional<Pizza> findById(long id) {
        return pizzaRepository.findById(id);
    }

    @Override
    public List<Pizza> findByAvailableAndNameContaining(String name) {
        return pizzaRepository.findAllByAvailabilityAndName(true, name);
    }

    @Override
    public Optional<Pizza> delete(long id) {
        Optional<Pizza> deletedPizza = pizzaRepository.findById(id);
        pizzaRepository.delete(deletedPizza);
        return deletedPizza;
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public List<Pizza> findAllAvailable() {
        return pizzaRepository.findAllByAvailability(true);
    }

    @Override
    public Pizza update(Pizza pizza) {
        return pizzaRepository.saveAndFlush(pizza);
    }
}
