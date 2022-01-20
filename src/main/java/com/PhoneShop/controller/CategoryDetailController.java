package com.PhoneShop.controller;

import com.PhoneShop.service.CategoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/category-detail-data")
public class CategoryDetailController {

    @Autowired
    private CategoryDetailService categoryDetailService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        return ok(categoryDetailService.findAll());
    }
}
