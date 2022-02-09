package com.PhoneShop.controller;

import com.PhoneShop.model.BillingOrder;
import com.PhoneShop.model.User;
import com.PhoneShop.service.OrderService;
import com.PhoneShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody BillingOrder billingOrder) {
        return ResponseEntity.ok(orderService.createOrder(billingOrder));
    }
}
