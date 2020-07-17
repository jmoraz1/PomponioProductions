package com.cenfotec.pomponio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(Model model) throws ParseException {
        return "home";
    }
    @RequestMapping("/index")
    public String index(Model model) throws ParseException {
        return "index";
    }
    @RequestMapping("/contact")
    public String contact(Model model) throws ParseException {
        return "contact";
    }

}
