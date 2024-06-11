package com.chgvcode.firstjobapp.review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review findById(Long companyId, Long reviewId);

    boolean updateReview(Long companyId, Long reviewId, Review review);

    boolean deleteReview(Long companyId, Long reviewId);
}
