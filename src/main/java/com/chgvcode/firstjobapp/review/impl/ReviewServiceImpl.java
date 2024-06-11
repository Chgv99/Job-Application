package com.chgvcode.firstjobapp.review.impl;

import com.chgvcode.firstjobapp.company.Company;
import com.chgvcode.firstjobapp.company.CompanyService;
import com.chgvcode.firstjobapp.review.Review;
import com.chgvcode.firstjobapp.review.ReviewRepository;
import com.chgvcode.firstjobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> findAll(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null){
            review.setCompany(company);
            reviewRepository.save(review);
        }
        return company != null;
    }

    @Override
    public Review findById(Long companyId, Long reviewId) {
        /*List<Review> reviews = findAll(companyId);
        for (Review review : reviews){
            if (Objects.equals(review.getId(), reviewId)) return review;
        }
        return null;*/
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review newReview) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        for (Review review : reviews) {
            if (review.getId().equals(reviewId)){
                review.setName(newReview.getName());
                review.setDescription(newReview.getDescription());
                review.setRating(newReview.getRating());
                //review.setCompany(newReview);
                reviewRepository.save(review);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        for (Review review : reviews){
            if (review.getId().equals(reviewId)) {
                reviewRepository.delete(review);
                return true;
            }
        }
        return false;
    }

}
