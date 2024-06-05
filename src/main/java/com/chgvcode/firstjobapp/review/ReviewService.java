package com.chgvcode.firstjobapp.review;

public interface ReviewService {

    void findAll();

    void findById(Long companyId);

    void addReview(Review review);
}
