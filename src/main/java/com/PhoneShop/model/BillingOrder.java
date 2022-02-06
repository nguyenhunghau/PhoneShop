package com.PhoneShop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillingOrder {
    private User user;
    private Order order;
}
