package kosenko.controllers;

import kosenko.service.interfaces.OrderService;
import kosenko.service.interfaces.ProductService;
import kosenko.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"orderMap", "orderList"})
public class OrderController {
    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;
}
