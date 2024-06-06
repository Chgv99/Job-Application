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

}
