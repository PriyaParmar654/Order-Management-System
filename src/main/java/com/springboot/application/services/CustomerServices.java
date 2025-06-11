package com.springboot.application.services;

import java.util.HashMap;
import java.util.List;

import com.springboot.application.entities.Customer;
import com.springboot.application.entities.Order;

public interface CustomerServices {
    Customer save(Customer customer);
    Customer findById(int id);
    HashMap<String, Object> getOrders(int cId);
    List<Customer> findAll();
    Customer findByMail(String email);
    Customer authenticate(String email, String password);
    void addOrder(Order order);
    void transaction(int amount, int cid);
}

