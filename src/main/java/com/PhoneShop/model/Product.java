package com.PhoneShop.model;

import com.PhoneShop.entity.CategorydetailEntity;
import com.PhoneShop.entity.ProducerEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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

    private CategoryDetail categoryDetail;

    private Producer producer;

    private Double price;

    private List<Productphoto> productphotoList;
}
