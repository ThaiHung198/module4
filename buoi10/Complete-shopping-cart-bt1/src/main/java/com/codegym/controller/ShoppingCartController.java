package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("cart")
@Controller
public class ShoppingCartController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }
    @GetMapping("products")
    public String showProductList(Model model){
        model.addAttribute("products", productService.findAll());
        return "products";
    }
    @GetMapping("/cart/add/{productId}")
    public String addToCart(@PathVariable("productId") Long productId,@ModelAttribute("cart")Cart cart){
        Product product = productService.findById(productId);
        if (product != null){
            cart.addItem(product);
        }
        return "redirect:/cart";
    }
    @GetMapping("/cart")
    public String showCart(Model model,@ModelAttribute("cart") Cart cart){
        model.addAttribute("cart", cart);
        return "cart";
    }
    @PostMapping("/cart/update")
    public String updateCart(@RequestParam("productId") Long productId,@RequestParam ("quantity") int quantity,@ModelAttribute("cart") Cart cart){
        cart.updateItem(productId, quantity);
        return "redirect:/cart";
    }
    @GetMapping("/cart/checkout")
    public String checkout(SessionStatus status){
        status.setComplete();
        return "redirect:/products";
    }

}
