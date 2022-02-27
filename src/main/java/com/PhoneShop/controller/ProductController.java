package com.PhoneShop.controller;

import com.PhoneShop.model.Category;
import com.PhoneShop.model.Product;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findByFilter(@RequestParam(name = "category-id") int categoryId, 
                                          @RequestParam(name = "sort", required = false) String sort) {
        return ok(productService.findByFilter(categoryId, sort));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProducts() {
        return ok(productService.getAllProducts());
    }

    @RequestMapping(value = "/important", method = RequestMethod.GET)
    public ResponseEntity<?> findImportantProducts() {
        return ok(productService.findImportantProducts());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id) {
        return ok(productService.findById(id));
    }

    @RequestMapping(value = "/slides", method = RequestMethod.GET)
    public ResponseEntity<?> findSlideImageList() {
        return ok(productService.findSlideImageList());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        return ok(productService.addProduct(product));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return ok(productService.updateProduct(product));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") int id) {
        return ok(productService.deleteProduct(id));
    }
}
