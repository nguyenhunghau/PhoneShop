package com.PhoneShop.service;

import com.PhoneShop.entity.CategoryEntity;
import com.PhoneShop.entity.CategorydetailEntity;
import com.PhoneShop.model.Category;
import com.PhoneShop.model.CategoryDetail;
import com.PhoneShop.repository.CategoryDetailRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDetailService {
    @Autowired
    private CategoryDetailRepository categoryDetailRepository;

    public List<CategoryDetail> findAll() {
        List<CategorydetailEntity> categoryEntityList = categoryDetailRepository.findAll();
        return new ModelMapper().map(categoryEntityList, new TypeToken<List<CategoryDetail>>() {}.getType());
    }
}
