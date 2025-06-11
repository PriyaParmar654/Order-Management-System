package com.springboot.application.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@AllArgsConstructor
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="c_id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(Order order) {
        orders.add(order);
    }

    @Column(name="firstName")
    private String first_name;

    @Column(name="lastName")
    private String last_name;

    private String state;
    private String city;
    private String landmark;
    private String pin;
    private String phone;
    private String mail;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date bod;

    private String password;

    @Column(name="walletbalance")
    private double walletBalance;

    @Column(name = "created_timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTimeStamp;

    @OneToMany(mappedBy = "cId", fetch = FetchType.EAGER)
    @Fetch(value=FetchMode.SUBSELECT)
    private List<Order> orders;

    @OneToMany(mappedBy = "cId", fetch = FetchType.EAGER)
    @Fetch(value=FetchMode.SUBSELECT)
    private List<Review> reviews;

    public Customer()
    {
        this.orders = new ArrayList<Order>();
        this.reviews=new ArrayList<Review>();
    }


    @Override
    public String toString() {
        return "Customer [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", state=" + state
                + ", city=" + city + ", landmark=" + landmark + ", pin=" + pin + ", phone=" + phone + ", mail=" + mail
                + ", bod=" + bod + ", password=" + password + ", walletBalance=" + walletBalance + ", createdTimeStamp="
                + createdTimeStamp + ", orders=" + orders + ", reviews=" + reviews + "]";
    }






}

