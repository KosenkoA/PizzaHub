package kosenko.service;

import kosenko.entity.Order;
import kosenko.entity.OrderedProduct;
import kosenko.entity.Product;
import kosenko.entity.User;
import kosenko.repository.OrderRepository;
import kosenko.service.interfaces.OrderService;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    @Resource
    OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order delete(long id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order update(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
        //return orderRepository.findOne(id);
    }

    @Override
    public Order createOrderFromMap(Map<Product, Integer> orderMap) {
        Order order = new Order();
        order.setTime(new Timestamp(new Date().getTime()));
        order.setOrderedProducts((List<OrderedProduct>) orderMap);
        return order;
    }

    @Override
    public Optional<Order> findByUserAndIdAndClosedFalse(User user, Long id) {
        return orderRepository.findByUserAndIdAndClosedFalse(user, id);
    }

    @Override
    public void onSubmitOrder(Map<Product, Integer> orderMap, User user, Long orderId) {
        Optional<Order> order = findByUserAndIdAndClosedFalse(user, orderId);
        /*if (order.isPresent()) {
            order.getOrderedProducts().addAll
        }
        */
    }

    @Override
    public Order closeOrder(Order order) {
        return null;
    }
}
