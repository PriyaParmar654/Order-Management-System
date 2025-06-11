package com.springboot.application.dta;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.application.entities.CustomisedProduct;
import com.springboot.application.entities.Product;

@Data
@AllArgsConstructor
public class CustomisedProductInputDto {

    private int id;
    private double price;
    private MultipartFile thumbnail;
    private String description;
    private double budget;
    private int cid;

    public static CustomisedProduct toEntity(CustomisedProductInputDto dto) {
        CustomisedProduct entity = new CustomisedProduct();
        BeanUtils.copyProperties(dto, entity, "thumbnail");
        return entity;
    }




}

