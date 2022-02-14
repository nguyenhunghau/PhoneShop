package com.PhoneShop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Promotion {
    private Integer id;
    private Double price;
    private Date startDate;
    private Date endDate;
}
