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

}
