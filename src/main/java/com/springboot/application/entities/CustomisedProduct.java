package com.springboot.application.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "customised_product")
public class CustomisedProduct {

    @Id
    @Column(name = "pid")
    private int id;
    private double price;
    private double budget;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_id")
    private Customer cust;
    private String thumbnail;
    private String description;

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    //@Column(name="c_id")
    //private int cid;

    @Override
    public String toString() {
        return "CustomisedProduct [id=" + id + ", price=" + price + ", budget=" + budget + ", thumbnail=" + thumbnail
                + ", description=" + description + "]";
    }

    public CustomisedProduct(int id, double price, double budget, String thumbnail, String description , int cid) {
        super();
        this.id = id;
        this.price = price;
        this.budget = budget;
        this.thumbnail = thumbnail;
        this.description = description;
        //this.cid=cid;
    }

    public CustomisedProduct() {}




}
