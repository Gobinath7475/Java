package com.kgisl.SpringExecg;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
// import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/")
    public String showPage() {
        return "home";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user( User user, Model model) {
        System.out.println("User Page Requested");
        model.addAttribute("userName", user.getUserName());

        String helloWorldMessage = "Hello world!";
        String welcomeMessage = "Welcome!";
        model.addAttribute("helloMessage", helloWorldMessage);
        model.addAttribute("welcomeMessage", welcomeMessage);
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
