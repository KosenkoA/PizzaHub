package kosenko.service.interfaces;

import kosenko.entity.OrderedProduct;
import kosenko.entity.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderedProductService {
    OrderedProduct create(OrderedProduct product);

    Optional<OrderedProduct> delete(long id);

    List<OrderedProduct> findAll();

    Optional<OrderedProduct> findById(long id);

    List<OrderedProduct> createOrderedProductsFromMap(Map<Product, Integer> orderMap);

    OrderedProduct createOrderedProductFromProduct(Product Product, int quantity);
}
