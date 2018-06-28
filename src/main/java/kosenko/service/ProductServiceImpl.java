package kosenko.service;

import kosenko.entity.Product;
import kosenko.repository.ProductRepository;
import kosenko.service.interfaces.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> findByAvailableAndId(long id) {
        return findById(id).filter(p -> p.isAvailability() == true);
    }

    @Override
    public List<Product> findByAvailableAndNameContaining(String name) {
        return productRepository.findAllByAvailabilityAndName(true, name);
    }

    @Override
    public Optional<Product> delete(long id) {
        Optional<Product> deletedProduct = productRepository.findById(id);
        productRepository.deleteById(id);
        return deletedProduct;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllAvailable() {
        return productRepository.findAllByAvailability(true);
    }

    @Override
    public Product update(Product product) {
        return productRepository.saveAndFlush(product);
    }
}
