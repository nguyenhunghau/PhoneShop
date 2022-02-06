package com.PhoneShop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Integer id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private Boolean gender;
    private String password;
    private String sessionId;
}
