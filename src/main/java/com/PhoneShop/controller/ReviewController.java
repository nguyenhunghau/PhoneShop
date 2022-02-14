package com.PhoneShop.controller;

import com.PhoneShop.model.Review;
import com.PhoneShop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{productId}")
    public ResponseEntity<List<Review>> getReviewListByProductId(@PathVariable(name = "productId") int productId) {
        return ResponseEntity.ok(reviewService.getReviewListByProductId(productId));
    }

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.addReview(review));
    }
}
