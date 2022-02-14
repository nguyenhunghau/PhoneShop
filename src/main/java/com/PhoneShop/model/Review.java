package com.PhoneShop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Review {
    private Integer id;
    private Integer score;
    private String description;
    private String name;
    private String email;
    private int productId;
    private int newsId;
    private Date createdDate;
}
