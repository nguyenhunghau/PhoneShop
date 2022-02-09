package com.PhoneShop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Order {
    private Integer userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date orderDate;
    private String address;
    private Date shipDate;
    private Double shipCost;
    private String promotionCode;
    private List<OrderDetail> orderDetailList;
}
