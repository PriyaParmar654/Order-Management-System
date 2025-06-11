package com.springboot.application.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "cat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String details;

    @Column(name = "created_timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTimeStamp;

    @OneToMany(mappedBy = "catId" , cascade = CascadeType.REMOVE)
    private List<Product> productList;

    public Category() {
        this.productList = new ArrayList<Product>();
    }



    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", details=" + details + ", createdTimeStamp="
                + createdTimeStamp + ", productLsit=" + productList + "]";
    }




}
