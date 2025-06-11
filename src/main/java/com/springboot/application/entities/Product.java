package com.springboot.application.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "p_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String thumbnail;
    private String details;
    private int qty;

    @Column(name = "cat_id")
    private int catId;

    @Column(name = "created_timestamp", insertable = false, updatable = false)
    private String createdTimeStamp;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Review> reviews;

    public Product() {
        this.reviews=new ArrayList<Review>();

    }
    public Product(String name, double price, String thumbnail, String details, int qty, int catId) {
        super();
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.details = details;
        this.qty = qty;
        this.catId = catId;
        this.reviews=new ArrayList<Review>();
    }

    public Product(String table, int i, Category fetchedCat, String _feet, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public void addReview(Review review) {
        reviews.add(review);
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", thumbnail=" + thumbnail + ", details="
                + details + ", qty=" + qty + ", catId=" + catId + ", createdTimeStamp=" + createdTimeStamp + "]";
    }



}

