package com.springboot.application.services;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.application.dao.CategoryDao;
import com.springboot.application.entities.Category;
// import com.project.etities.Order;

@Transactional
@Service
public class CategoryServicesImpl implements CategoryServices {

    @Autowired
    private CategoryDao catDao;

    @Override
    public Category save(Category category) {
        Category cat = catDao.save(category);
        System.out.println(cat);
        return cat;
    }

    @Override
    public Category findById(int id) {
        Optional<Category> id2 = catDao.findById(id);
        return id2.orElse(null);

        
    }

    @Override
    public List<Category> findAll() {
        return catDao.findAll();
    }

    @Override
    public Category saveCategory(Category category) {

        return catDao.save(category);
    }


    @Override public Category findByName(String name) {
        Category name1 = catDao.findByName(name);
        if(name!=null)
            return name1;
        return null;

    }
    @Override
    public void delete(Category catg) {
        catDao.delete(catg);

    }

    @Override
    public void deleteById(int id) {
        catDao.deleteById(id);
    }



}
