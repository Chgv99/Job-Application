package com.chgvcode.firstjobapp.review;

import com.chgvcode.firstjobapp.company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {

    private ReviewService reviewService;

    private CompanyService companyService;

    public ReviewController(ReviewService reviewService, CompanyService companyService) {
        this.reviewService = reviewService;
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.findAll(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review){
        if (reviewService.addReview(companyId, review)){
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not added", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        /*Review review = reviewService.findById(companyId, reviewId);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);*/
        return new ResponseEntity<>(reviewService.findById(companyId, reviewId), HttpStatus.OK);
    }
}


/*  Reviews
    GET /companies/{companyId}/reviews
    POST /companies/{companyId}/reviews
    GET /companies/{companyId}/reviews/{reviewId}
    PUT /companies/{companyId}/reviews/{reviewId}
    DELETE /companies/{companyId}/reviews/{reviewId}
     */