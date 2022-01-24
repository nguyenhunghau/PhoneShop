package com.PhoneShop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ImportantProduct {
    private List<Product> productList;
    private Category category;
}
