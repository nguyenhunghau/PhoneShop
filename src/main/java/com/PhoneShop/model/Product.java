package com.PhoneShop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Product {

    private Integer id;
    private String code;
    private String name;
    private String parameter;
    private String detail;
    private String description;
    private Date productLaunchDate;

    private CategoryDetail categoryDetail;

    private Producer producer;

    private Double price;

    private List<Productphoto> productphotoList;
}
