package com.chgvcode.firstjobapp.review.impl;

import com.chgvcode.firstjobapp.review.Review;
import com.chgvcode.firstjobapp.review.ReviewRepository;
import com.chgvcode.firstjobapp.review.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void findAll() {
        reviewRepository.findAll();
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void findById(Long companyId) {
        reviewRepository.findById(companyId);
    }

}
