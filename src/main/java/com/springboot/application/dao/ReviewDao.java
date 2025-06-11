package com.springboot.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.springboot.application.entities.Product;
import com.springboot.application.entities.Review;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDao extends JpaRepository<Review, Integer>{


//    @Query("SELECT avg(star) from Review where p_id=(:pid) group by p_id")
//    Double getAverageStar(@Param("pid") int pid);

    @Query("SELECT AVG(r.star) FROM Review r WHERE r.product.id = :pid GROUP BY r.product.id")
    Double getAverageStar(@Param("pid") int pid);

    Review save(Review review);
}
