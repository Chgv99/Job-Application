package com.chgvcode.firstjobapp.review;

import com.chgvcode.firstjobapp.company.CompanyService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    private ReviewService reviewService;

    private CompanyService companyService;

    public ReviewController(ReviewService reviewService, CompanyService companyService) {
        this.reviewService = reviewService;
        this.companyService = companyService;
    }

    @GetMapping("/companies/{companyId}/reviews")
    public void getReviews(){
        reviewService.findAll();
    }

    @PostMapping("/companies/{companyId}/reviews")
    public void createReview(@PathVariable Long companyId, @RequestBody Review review){
        review.setCompany(companyService.getCompanyById(companyId));
        reviewService.addReview(review);
    }

    @GetMapping("/companies/{companyId}/reviews/{reviewId}")
    public void getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        //reviewService.findById(companyId);
    }
}


/*  Reviews
    GET /companies/{companyId}/reviews
    POST /companies/{companyId}/reviews
    GET /companies/{companyId}/reviews/{reviewId}
    PUT /companies/{companyId}/reviews/{reviewId}
    DELETE /companies/{companyId}/reviews/{reviewId}
     */