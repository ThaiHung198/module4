package com.codegym.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class IndexController {
    @RequestMapping("/")
    public String get(Model model) {
        model.addAttribute("message", "Home Page!");
        return "/home";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Index Page!");
        return "/index";
    }
}
