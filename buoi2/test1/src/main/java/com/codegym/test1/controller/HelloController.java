package com.codegym.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("/car?/s?o?/infor1")
    public String infor1(Model model){
        model.addAttribute("message", "Infor1");
        return "/index";
    }
    @RequestMapping("/c*/s*d/info2")
    public ModelAndView info2(){
        ModelAndView model = new ModelAndView("/index");
        model.addObject("message", "Infor2");
        return model;
    }
}
