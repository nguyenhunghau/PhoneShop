package com.PhoneShop.repository;

import com.PhoneShop.entity.ProductphotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductPhotoRepository extends JpaRepository<ProductphotoEntity, Integer> {

    public List<ProductphotoEntity> findByproductEntity_Id(Integer productId);
}
