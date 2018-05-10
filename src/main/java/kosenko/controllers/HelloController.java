package kosenko.controllers;

import kosenko.controllers.util.ViewName;
import kosenko.entity.Pizza;
import kosenko.service.interfaces.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HelloController {
    @Autowired
    private PizzaService pizzaService;

/*
    //@GetMapping(value = "/hello")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String sayHello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
*/

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView hello() {
        List<Pizza> allPizzas;
        allPizzas=pizzaService.findAllAvailable().stream().collect(Collectors.toList());

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("pizzas",allPizzas);
        modelAndView.setViewName("hello");
        return modelAndView;
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
