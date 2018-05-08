package kosenko.Controller;

import kosenko.Controller.Util.ViewName;
import kosenko.Service.interfaces.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class HelloController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping(value = "/hello")
    //@RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
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
