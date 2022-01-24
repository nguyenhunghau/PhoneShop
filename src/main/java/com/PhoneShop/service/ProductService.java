package com.PhoneShop.service;

import com.PhoneShop.entity.CategoryEntity;
import com.PhoneShop.entity.ProductEntity;
import com.PhoneShop.model.Category;
import com.PhoneShop.model.ImportantProduct;
import com.PhoneShop.model.Product;
import com.PhoneShop.repository.CategoryRepository;
import com.PhoneShop.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product findById(int id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        return new ModelMapper().map(productEntity, Product.class);
    }

    public List<Product> findByFilter(int categoryId, String sort) {
        List<ProductEntity> categoryEntityList = productRepository.findByCategory(categoryId);
        if("price".equals(sort)) {
            categoryEntityList = productRepository.findByCategorydetailEntity_CategoryEntity_IdOrderByPriceAsc(categoryId);
        } else if("price-desc".equals(sort)) {
            categoryEntityList = productRepository.findByCategorydetailEntity_CategoryEntity_IdOrderByPriceDesc(categoryId);
        }else if("date".equals(sort)){
            categoryEntityList = productRepository.findByCategorydetailEntity_CategoryEntity_IdOrderByProductLaunchDateDesc(categoryId);
        }
        return new ModelMapper().map(categoryEntityList, new TypeToken<List<Product>>() {}.getType());
    }

    public List<ImportantProduct> findImportantProducts() {
        List<ImportantProduct> importantProductList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        for(CategoryEntity categoryEntity: categoryEntityList) {
            List<ProductEntity> productEntityList = productRepository.findImportantsByCategory(categoryEntity.getId());

            Category category = modelMapper.map(categoryEntity, Category.class);
            List<Product> productList = modelMapper.map(productEntityList, new TypeToken<List<Product>>() {}.getType());
            importantProductList.add(new ImportantProduct(productList, category));
        }
        return importantProductList;
    }
}
