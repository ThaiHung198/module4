package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Long, CartItem> items = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Long, CartItem> items) {
        this.items = items;
    }
    public void addItem(Product product) {
        CartItem cartItem = items.get(product.getId());
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }else {
            items.put(product.getId(), new CartItem(product,1));
        }
    }
    public void updateItem(Long ProductId, int quantity) {
        CartItem cartItem = items.get(ProductId);
        if (cartItem != null) {
            if (quantity > 0) {
                cartItem.setQuantity(quantity);
            }else {
                items.remove(ProductId);
            }
        }
    }
    public void removeItem(Long ProductId) {
        items.remove(ProductId);
    }
    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items.values()) {
            total += item.getSubtotal();
        }
        return total;
    }

}
