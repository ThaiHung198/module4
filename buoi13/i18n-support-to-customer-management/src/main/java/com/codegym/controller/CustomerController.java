package com.codegym.controller;

import com.codegym.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @GetMapping
    public String listCustomers(Model model) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "John", "john85@gmail.com"));
        customers.add(new Customer(2L, "Jane", "jane80@gmail.com"));
        customers.add(new Customer(3L, "Bob", "bob00@gmail.com"));
        model.addAttribute("customers", customers);
        return "customers";
    }
}
