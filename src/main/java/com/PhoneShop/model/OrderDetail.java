package com.PhoneShop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {
    private Integer id;
    private Integer productId;
    private Integer variantId;
    private Integer quantity;
}
