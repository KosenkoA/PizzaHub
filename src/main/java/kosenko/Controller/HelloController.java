package kosenko.Controller;

import kosenko.Controller.Util.ViewName;
import kosenko.Service.interfaces.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping(value = {"/", "/welcome**"})
    public String welcome() {
        return "Welcome";
    }

    @GetMapping(value = "/layoutgrid")//Whole method is complete bullshit
    public ModelAndView layoutgrid() {
        return new ModelAndView(ViewName.MENU, "menuItems",
                pizzaService.findAllAvailable());
    }
}
