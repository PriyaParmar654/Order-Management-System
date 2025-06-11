package com.springboot.application.services;

import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.springboot.application.dao.ProductDao;
import com.springboot.application.dao.ReviewDao;
import com.springboot.application.entities.Product;

@Transactional
@Service
public class ProductServicesImpl implements ProductServices{

    @Autowired
    private ProductDao productDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    ReviewDao revDao;

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    public Product findById(int i) {
        Optional<Product> p= productDao.findById(i);
        Product product=p.orElse(null);
        return product;

    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }


    @Override
    public List<Product> findByPriceBetween(double minPrice, double maxPrice) {
        return productDao.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public Product saveProduct(Product product, MultipartFile thumbnail) {
        String fileName = storageService.store(thumbnail);
        product.setThumbnail(fileName);
        return productDao.save(product);

    }

    @Override
    public Double getAverageStar(int pid) {
        return revDao.getAverageStar(pid);
    }


    @Override
    public void delete(Product product) {
        productDao.delete(product);

    }







}
