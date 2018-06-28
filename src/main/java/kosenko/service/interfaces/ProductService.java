package kosenko.service.interfaces;

import kosenko.entity.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    Product create(Product product);

    Optional<Product> findById(long id);

    List<Product> findByAvailableAndNameContaining(String name);

    Optional<Product> delete(long id);

    List<Product> findAll();

    List<Product> findAllAvailable();

    Product update(Product product);
}
