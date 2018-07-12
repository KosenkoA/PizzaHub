package kosenko.repository;

import kosenko.entity.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long> {
    void delete(Optional<OrderedProduct> deletedOrderedProduct);
}
