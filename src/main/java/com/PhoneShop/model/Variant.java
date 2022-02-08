package com.PhoneShop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Variant {
    private Integer id;
    private String name;
    private String category;
    private Double price;
}
