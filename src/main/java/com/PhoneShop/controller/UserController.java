package com.PhoneShop.controller;

import com.PhoneShop.model.BillingOrder;
import com.PhoneShop.model.User;
import com.PhoneShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public ResponseEntity<?> getUserBySessionId(@RequestParam(name = "session-id") String sessionId) {
        return ResponseEntity.ok(userService.findBySessionId(sessionId));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.createAccount(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(userService.login(user));
    }
}
