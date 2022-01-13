package com.PhoneShop.service;

import com.PhoneShop.entity.CategoryEntity;
import com.PhoneShop.model.Category;
import com.PhoneShop.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        return new ModelMapper().map(categoryEntityList, new TypeToken<List<Category>>() {}.getType());
    }

    public Category findById(int id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        return new ModelMapper().map(categoryEntity, Category.class);
    }
}
