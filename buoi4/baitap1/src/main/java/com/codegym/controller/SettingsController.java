package com.codegym.controller;

import com.codegym.model.EmailSettings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingsController {
    private static EmailSettings currentSettings = new EmailSettings("English",25,false,"Thor\nKing,Asgrd");

    @GetMapping("/settings")
    public ModelAndView showSettingsForm() {
        ModelAndView modelAndView = new ModelAndView("settings");
        modelAndView.addObject("settings", currentSettings);
        modelAndView.addObject("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSizes",new int[]{5,10,15,25,50,100});
        return modelAndView;
    }

    @PostMapping("/update-settings")
    public String updateSettings(@ModelAttribute("settings") EmailSettings newSettings) {
        currentSettings = newSettings;
        return "redirect:/settings";
    }
}
