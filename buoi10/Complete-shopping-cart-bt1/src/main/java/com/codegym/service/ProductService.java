package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1L,"iPhone 14 Pro Max",2500000.0));
        products.add(new Product(2L,"Samsung Galaxy S23 Ultra",2300000.0));
        products.add(new Product(3L,"Macbook Pro M2",5500000.0));
        products.add(new Product(4L,"Dell XPS 15",4500000.0));

    }
    public List<Product> findAll() {
        return products;
    }
    public Product findById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
