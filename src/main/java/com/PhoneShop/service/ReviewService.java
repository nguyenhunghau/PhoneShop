package com.PhoneShop.service;

import com.PhoneShop.entity.ReviewsEntity;
import com.PhoneShop.model.Category;
import com.PhoneShop.model.Review;
import com.PhoneShop.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviewListByProductId(int productId) {
        List<ReviewsEntity> reviewsEntityList = reviewRepository.findByProductId(productId);
        return new ModelMapper().map(reviewsEntityList, new TypeToken<List<Review>>() {}.getType());
    }

    public Review addReview(Review review) {
        ReviewsEntity reviewsEntity = new ModelMapper().map(review, ReviewsEntity.class);
        reviewsEntity.setCreatedDate(new Date());
        ReviewsEntity newReviewEntity = reviewRepository.save(reviewsEntity);
        return new ModelMapper().map(newReviewEntity, Review.class);
    }
}
