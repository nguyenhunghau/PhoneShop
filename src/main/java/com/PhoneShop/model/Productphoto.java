package com.PhoneShop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Productphoto {
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String photo;

    private boolean isDefault;

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
