package com.codegym.service;

import com.codegym.model.Product;

import java.util.*;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1,new Product(1,"trứng gà",3000.0,"Trứng gà công nghiệp","Nhà farm TH"));
        products.put(2,new Product(2,"Gà đẻ",120000.0,"Gà để 1 lứa","Nhà farm TH"));
        products.put(3,new Product(3,"Gà trống",150000.00,"Gà trống 6 tháng","Nhà farm TH"));
        products.put(4,new Product(4,"Trứng Vịt",10000.0,"Trứng vịt trời","Nhà farm TH"));
        products.put(5,new Product(5,"Vịt trời",250000.0,"Vịt trời thả tự nhiên","Nhà farm TH"));
        products.put(6,new Product(6,"Ngan",180000.0,"Ngan thả đồi","Nhà farm TH"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
