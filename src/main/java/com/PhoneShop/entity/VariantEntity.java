/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PhoneShop.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "variant")
@Getter
@Setter
public class VariantEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private ProductEntity productEntity;

    @Column(name = "category")
    private String category;
    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy="variantEntity")
    private List<PromotionEntity> promotionEntityList;

    public VariantEntity() {
    }

    public VariantEntity(Integer id) {
        this.id = id;
    }

}
