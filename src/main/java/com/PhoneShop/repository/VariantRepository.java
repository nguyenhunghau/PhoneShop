package com.PhoneShop.repository;

import com.PhoneShop.entity.VariantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VariantRepository extends JpaRepository<VariantEntity, Integer> {
    public List<VariantEntity> findByproductEntity_Id(Integer productId);
}
