package com.codegym.controller;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }
    @GetMapping("/{id}/delete")
    public String detele(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
    @PostMapping("/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/customers";
    }
    @PostMapping("update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/customers";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully");
        return "redirect:/products";
    }
}
