package com.springboot.application.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.application.entities.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{



    Category findByName(String name);
    void deleteById(int id);
}

