package com.springboot.application.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="review")
public class Review {
    @Id
    @Column(name="r_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rId;
    private String description;
    private int star;

    @ManyToOne
    @JoinColumn(name = "p_id", nullable = false)
    private Product product;

    @Column(name="c_id")
    private int cId;

    @Override
    public String toString() {
        return "Review [rId=" + rId + ", description=" + description + ", star=" + star + ", product=" + product + ", cId="
                + cId + "]";
    }



    public Review(String description, int star, Product product, int cId) {
        super();
        this.description = description;
        this.star = star;
        this.product = product;
        this.cId = cId;
    }

    public Review() {}

}

