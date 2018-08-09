package kosenko.controllers;

import kosenko.entity.OrderedProduct;
import kosenko.entity.Product;
import kosenko.service.interfaces.OrderService;
import kosenko.service.interfaces.ProductService;
import kosenko.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes({"orderMap", "orderList"})
public class OrderController {
    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/addToOrder/{id}")
    public RedirectView addToOrder(@PathVariable(value = "id") long id, @ModelAttribute("orderMap") Map<Product, Integer> orderMap, HttpServletRequest request) {
        Optional<Product> product = productService.findById(id);
        product.ifPresent(p -> {
            if (orderMap.containsKey(p)) {
                orderMap.put(p, orderMap.get(p) + 1);
            } else {
                orderMap.put(p, 1);
            }
        });
        return new RedirectView(request.getHeader("referer"));
    }

    @GetMapping(value = "/removeFromOrder/{id}")
    public RedirectView removeFromOrder(@PathVariable(value = "id") long id,
                                        @ModelAttribute("orderMap") Map<Product, Integer> orderMap,
                                        HttpServletRequest request) {
        Optional<Product> product = productService.findById(id);
        product.ifPresent(orderMap::remove);
        return new RedirectView(request.getHeader("referer"));
    }

    @GetMapping(value = "/submitOrder")
    public RedirectView submitOrder(@ModelAttribute("orderMap") Map<Product, Integer> orderMap,
                                    @ModelAttribute("orderedList") List<OrderedProduct> orderedDishes) {
        orderService.onSubmitOrder(table.getCurrentTable(), orderMap);
        orderService.onSubmitOrder(orderMap, );
        orderMap.clear();
        return new RedirectView("/order");
    }
}
