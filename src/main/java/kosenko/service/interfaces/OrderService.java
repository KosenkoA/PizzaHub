package kosenko.service.interfaces;

import kosenko.entity.Order;
import kosenko.entity.Product;
import kosenko.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface OrderService {
    Order create(Order order);

    Order delete(long id);

    List<Order> findAll();

    Order update(Order order);

    Optional<Order> findById(long id);

    Order createOrderFromMap(Map<Product, Integer> orderMap);

    Optional<Order> findByUserAndIdAndClosedFalse(User user, Long id);

    void onSubmitOrder(Map<Product, Integer> orderMap, User user, Long orderId);

    Order closeOrder(Order order);
}
