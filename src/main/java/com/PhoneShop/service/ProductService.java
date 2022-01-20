package com.PhoneShop.service;

import com.PhoneShop.entity.CategoryEntity;
import com.PhoneShop.entity.ProductEntity;
import com.PhoneShop.model.Category;
import com.PhoneShop.model.Product;
import com.PhoneShop.repository.CategoryRepository;
import com.PhoneShop.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(int id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        return new ModelMapper().map(productEntity, Product.class);
    }

    public List<Product> findByFilter(int categoryId, String sort) {
        List<ProductEntity> categoryEntityList = productRepository.findByCategory(categoryId);
        if("price".equals(sort)) {
            categoryEntityList = productRepository.findByCategoryWithSortASC(categoryId);
        } else if("price-desc".equals(sort)) {
            categoryEntityList = productRepository.findByCategoryWithSortDESC(categoryId);
        }
        return new ModelMapper().map(categoryEntityList, new TypeToken<List<Product>>() {}.getType());
    }
}
