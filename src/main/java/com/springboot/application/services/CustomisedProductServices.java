package com.springboot.application.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.application.entities.CustomisedProduct;
import com.springboot.application.entities.Product;


public interface CustomisedProductServices {

    CustomisedProduct save(CustomisedProduct product);

    List<CustomisedProduct> findAll();

    CustomisedProduct saveProduct(CustomisedProduct product, MultipartFile thumbnail);

    CustomisedProduct findById(int id);

}
