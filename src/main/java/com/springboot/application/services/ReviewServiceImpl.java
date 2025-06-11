package com.springboot.application.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.application.dao.ReviewDao;
import com.springboot.application.entities.Review;

@Transactional
@Service
public class ReviewServiceImpl implements ReviewServices{

    @Autowired
    private ReviewDao reviewDao;

    @Override
    public Review addReview(Review review) {
        Review reviewNew = reviewDao.save(review);
        return reviewNew;
    }



}
