package com.springboot.application.dao;


import org.springframework.data.jpa.repository.JpaRepository;

// import com.project.etities.Category;
import com.springboot.application.entities.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

    // Customer save(Customer customer);
    Customer findById(int id);
    // List<Customer> findAll();
    Customer findByMail(String email);
}
