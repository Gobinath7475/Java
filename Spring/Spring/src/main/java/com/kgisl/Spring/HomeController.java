package com.kgisl.Spring;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    {
        System.out.println("home control loaded");
    }
    // field level or variable level
    // @Autowired
     private Employee employee;

    //Constructor injuction
     public HomeController(Employee employee)
    {
        this.employee = employee;
    }

    @RequestMapping("/")
    public String showPage() {
        employee.show();
        return "home";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(@Validated User user, Model model) {
        System.out.println("User Page Requested");
        model.addAttribute("userName", user.getUserName());
        return "user";
    }

    @RequestMapping("/hello")
    public String hello(ModelMap map) {
        String helloWorldMessage = "Hello world!";
        String welcomeMessage = "Welcome!";
        map.addAttribute("helloMessage", helloWorldMessage);
        map.addAttribute("welcomeMessage", welcomeMessage);
        return "home";
    }
}
