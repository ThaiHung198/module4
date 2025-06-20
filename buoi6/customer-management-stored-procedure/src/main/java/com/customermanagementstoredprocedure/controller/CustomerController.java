package com.customermanagementstoredprocedure.controller;

import com.customermanagementstoredprocedure.model.Customer;
import com.customermanagementstoredprocedure.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView mav = new ModelAndView("create");
        mav.addObject("customer", new Customer());
        return mav;
    }
    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        boolean checkSave = customerService.saveWithStoredProcedure(customer);
        ModelAndView mav = new ModelAndView("create");
        mav.addObject("customer", new Customer());
        if (checkSave) {
            mav.addObject("message", "Customer saved successfully");
        }else {
            mav.addObject("message", "Error exitsts!");
        }
        return mav;
    }
}
