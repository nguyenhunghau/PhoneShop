package com.PhoneShop.controller;

import com.PhoneShop.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/producer-data")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> showProducerPhoto() {
        return ok(producerService.findAll());
    }
}
