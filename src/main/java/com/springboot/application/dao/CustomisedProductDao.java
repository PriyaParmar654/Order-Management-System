package com.springboot.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.application.entities.CustomisedProduct;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomisedProductDao extends JpaRepository<CustomisedProduct, Integer>{

}