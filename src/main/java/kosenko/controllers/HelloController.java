package kosenko.controllers;

import kosenko.controllers.util.FuncClass;
import kosenko.controllers.util.ViewName;
import kosenko.entity.Pizza;
import kosenko.service.interfaces.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
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

    @RequestMapping(value = "/hello/show/{id}",method = RequestMethod.GET)
    public ModelAndView getPizzaById(@PathVariable("id") long id){
        //Optional<Pizza> pizza=this.pizzaService.findById(id);

        List <Pizza> pizza = FuncClass.toList(this.pizzaService.findById(id));


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pizza",pizza);
        modelAndView.setViewName("show");//We are searching for "show.jsp" file and rendering information with this file
        return modelAndView;


        //return this.pizzaService.findById(id);
    }

    @RequestMapping(value = "test")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("message", "Baeldung");
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
