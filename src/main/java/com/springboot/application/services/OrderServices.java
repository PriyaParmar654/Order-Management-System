package com.springboot.application.services;

import java.util.List;
import java.util.Optional;

import com.springboot.application.entities.Order;


public interface OrderServices {
    Order save(Order order);
    Optional<Order> findByCId(int cid);
    Order cancelOrder(int oid);
    List<Order> findAll();
    Order findById(int oid);
    List<Order> findByStatus(String string);
    List<Order> findByStatusNot(String string);
    int getMinStaffId();
    List<Order> findByStaff(int id);

}