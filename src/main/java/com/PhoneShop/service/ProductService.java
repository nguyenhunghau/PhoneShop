package com.PhoneShop.service;

import com.PhoneShop.entity.CategoryEntity;
import com.PhoneShop.entity.ProductEntity;
import com.PhoneShop.entity.PromotionEntity;
import com.PhoneShop.entity.VariantEntity;
import com.PhoneShop.model.*;
import com.PhoneShop.repository.CategoryRepository;
import com.PhoneShop.repository.ProductRepository;
import org.aspectj.weaver.ast.Var;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product findById(int id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        Product product = new ModelMapper().map(productEntity, Product.class);
        if(!CollectionUtils.isEmpty(productEntity.getPromotionEntityList())) {
            Promotion promotion = getPromotionByProduct(productEntity.getPromotionEntityList());
            product.setPromotion(promotion);
        }
        if(!CollectionUtils.isEmpty(productEntity.getVariantEntityList())) {
            List<Variant> variantList = createVariantListWithPromotion(productEntity.getVariantEntityList());
            product.setVariantList(variantList);
        }

        return product;
    }

    private Promotion getPromotionByProduct(List<PromotionEntity> promotionEntityList) {
        for(PromotionEntity item : promotionEntityList) {
            Date currentDate = new Date();
            if(currentDate.compareTo(item.getStartDate()) >= 0 && currentDate.compareTo(item.getEndDate()) <=0) {
                return new ModelMapper().map(item, Promotion.class);
            }
        }
        return null;
    }

    private List<Variant> createVariantListWithPromotion(List<VariantEntity> variantList) {
        List<Variant> list = new ArrayList<>();
        for(VariantEntity item: variantList) {
            Variant variant = new ModelMapper().map(item, Variant.class);
            if(!CollectionUtils.isEmpty(item.getPromotionEntityList())) {
                Promotion promotion = getPromotionByProduct(item.getPromotionEntityList());
                variant.setPromotion(promotion);
            }
            list.add(variant);
        }
        return list;
    }

    public List<Product> findByFilter(int categoryId, String sort) {
        List<ProductEntity> categoryEntityList = productRepository.findByCategory(categoryId);
        if("price".equals(sort)) {
            categoryEntityList = productRepository.findByCategoryWithSortASC(categoryId);
        } else if("price-desc".equals(sort)) {
            categoryEntityList = productRepository.findByCategoryWithSortDESC(categoryId);
        }else if("date".equals(sort)){
            categoryEntityList = productRepository.findByCategoryWithSortByDateDESC(categoryId);
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
