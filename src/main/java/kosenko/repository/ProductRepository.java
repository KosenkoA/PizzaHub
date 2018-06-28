package kosenko.repository;

import kosenko.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    List<Product> findAllByAvailability(Boolean availability);

    List<Product> findAllByAvailabilityAndName(Boolean availability, String name);

    Optional<Product> deleteById(long id);
}
