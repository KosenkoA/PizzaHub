package kosenko.repository;

import kosenko.entity.Order;
import kosenko.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByClosedFalse();

    Optional<Order> findByUserAndIdAndClosedFalse(User user, Long id);
}
