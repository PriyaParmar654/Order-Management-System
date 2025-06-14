package com.springboot.application.services;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.application.dao.CustomisedProductDao;
import com.springboot.application.entities.CustomisedProduct;

@Transactional
@Service
public class CustomisedProductServicesImpl implements CustomisedProductServices{

    @Autowired
    private CustomisedProductDao custProDao;

    @Autowired
    private StorageService storageService;


    @Override
    public CustomisedProduct save(CustomisedProduct product) {

        return custProDao.save(product);
    }

    @Override
    public List<CustomisedProduct> findAll() {

        return custProDao.findAll();
    }

    @Override
    public CustomisedProduct saveProduct(CustomisedProduct product, MultipartFile thumbnail) {
        String fileName = storageService.store(thumbnail);
        product.setThumbnail(fileName);
        return custProDao.save(product);

    }

    @Override
    public CustomisedProduct findById(int id) {
        Optional<CustomisedProduct> p= custProDao.findById(id);
        CustomisedProduct product=p.orElse(null);
        return product;

    }

}

