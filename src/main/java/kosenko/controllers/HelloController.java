package kosenko.controllers;

import kosenko.controllers.util.FuncClass;
import kosenko.controllers.util.ViewName;
import kosenko.entity.Product;
import kosenko.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HelloController {
    @Autowired
    private ProductService productService;

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
        List<Product> allProducts;
        allProducts = productService.findAllAvailable().stream().collect(Collectors.toList());

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("products", allProducts);
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping(value = "/hello/show/{id}",method = RequestMethod.GET)
    public ModelAndView getProductById(@PathVariable("id") long id) {
        //Optional<Product> product=this.productService.findById(id);

        List<Product> product = FuncClass.toList(this.productService.findById(id));


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("show");//We are searching for "show.jsp" file and rendering information with this file
        return modelAndView;


        //return this.productService.findById(id);
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
                productService.findAllAvailable());
    }
}
