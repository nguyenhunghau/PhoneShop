package com.PhoneShop.repository;

import com.PhoneShop.entity.CategoryEntity;
import com.PhoneShop.entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    public List<ProductEntity> findByCategory(@Param("categoryId") int categoryId);

    public List<ProductEntity> findImportantsByCategory(@Param("categoryId") int categoryId);

    public List<ProductEntity> findByCategoryWithSortASC(@Param("categoryId") int categoryId);

    public List<ProductEntity> findByCategoryWithSortDESC(@Param("categoryId") int categoryId);

    public  List<ProductEntity> findByCategoryWithSortByDateDESC(@Param("categoryId") int categoryId);
}
