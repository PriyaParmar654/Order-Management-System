package com.springboot.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.application.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

    Product save(Product product);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);




}