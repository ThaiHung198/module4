package com.codegym.thuchanhqlydanhsachkhachhang.service;

import com.codegym.thuchanhqlydanhsachkhachhang.model.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
}