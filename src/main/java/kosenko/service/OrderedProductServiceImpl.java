package kosenko.service;

import kosenko.entity.OrderedProduct;
import kosenko.entity.Product;
import kosenko.repository.OrderedProductRepository;
import kosenko.service.interfaces.OrderedProductService;
import kosenko.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderedProductServiceImpl implements OrderedProductService {

    @Resource
    OrderedProductRepository orderedProductRepository;

    @Autowired
    ProductService productService;

    @Override
    public OrderedProduct create(OrderedProduct product) {
        return orderedProductRepository.save(product);
    }


    @Override
    @Transactional
    public Optional<OrderedProduct> delete(long id) {
        Optional<OrderedProduct> deletedOrderedProduct = orderedProductRepository.findById(id);
        if (deletedOrderedProduct.isPresent()) {
            orderedProductRepository.deleteById(id);
        }
        return deletedOrderedProduct;
    }

    @Override
    public List<OrderedProduct> findAll() {
        return orderedProductRepository.findAll();
    }

    @Override
    public Optional<OrderedProduct> findById(long id) {
        return orderedProductRepository.findById(id);
    }


    @Override
    public List<OrderedProduct> createOrderedProductsFromMap(Map<Product, Integer> orderMap) {
        List<OrderedProduct> orderedProducts = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : orderMap.entrySet()) {
            orderedProducts.add(createOrderedProductFromProduct(entry.getKey(), entry.getValue()));
        }
        return orderedProducts;
    }

    @Override
    public OrderedProduct createOrderedProductFromProduct(Product product, int quantity) {
        OrderedProduct orderedProduct = new OrderedProduct();
        orderedProduct.setProduct(product);
        orderedProduct.setQuantity(quantity);
        return orderedProduct;
    }
}
