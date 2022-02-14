package com.PhoneShop.repository;

import com.PhoneShop.entity.ReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewsEntity, Integer> {

    public List<ReviewsEntity> findByProductId(int productId);
}
