package com.springboot.application.services;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.springboot.application.entities.Product;


public interface ProductServices {
    Product save(Product product);

    List<Product> findAll();

    Product findById(int id);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    Product saveProduct(Product product, MultipartFile thumbnail);

    Double getAverageStar(int pid);


    void delete(Product product);



}
