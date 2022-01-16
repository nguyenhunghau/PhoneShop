package com.PhoneShop.controller;

import com.PhoneShop.model.Category;
import com.PhoneShop.service.CategoryService;
import com.PhoneShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<?> findAll() {
//        return ok(categoryService.findAll());
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id) {
        return ok(productService.findById(id));
    }


}
