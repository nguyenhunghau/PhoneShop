package com.PhoneShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/category")
    public String category() {
        return "pages/category.html";
    }

    @GetMapping("/news")
    public String News() {
        return "pages/news.html";
    }
    @GetMapping("/question-and-answer")
    public String questionAndAnswer() {
        return "pages/question-and-answer.html";
    }

    @GetMapping("/cart")
    public String cart() {
        return "pages/cart.html";
    }

    @GetMapping("/billing-information")
    public String billingInformation() {
        return "pages/billing-information.html";
    }

    @GetMapping("/order-success")
    public String orderSuccess() {
        return "pages/order-success.html";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login.html";
    }

    @GetMapping("/register")
    public String register() {
        return "pages/register.html";
    }

    @GetMapping("/admin")
    public String admin() {
        return "pages/admin/index.html";
    }

    @GetMapping("/admin-product")
    public String adminProduct() {
        return "pages/admin/product.html";
    }

    @GetMapping("/admin-add-product")
    public String adminAddProduct() {
        return "pages/admin/add-product.html";
    }
}
