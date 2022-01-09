package com.PhoneShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/home")
    public String homePage() {
        return "pages/home.html";
    }

    @GetMapping("/product-detail")
    public String productDetail() {
        return "pages/product-detail.html";
    }
}
