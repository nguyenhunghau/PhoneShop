package com.PhoneShop.controller;

import com.PhoneShop.model.Category;
import com.PhoneShop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/category-data")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        return ok(categoryService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id) {
        return ok(categoryService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        return ok(categoryService.addCategory(category));
    }
}
