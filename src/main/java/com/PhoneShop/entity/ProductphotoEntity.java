/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PhoneShop.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "productphoto")
@Getter
@Setter
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "ProductphotoEntity.findAll", query = "SELECT p FROM ProductphotoEntity p")
//    , @NamedQuery(name = "ProductphotoEntity.findById", query = "SELECT p FROM ProductphotoEntity p WHERE p.id = :id")
//    , @NamedQuery(name = "ProductphotoEntity.findByPhoto", query = "SELECT p FROM ProductphotoEntity p WHERE p.photo = :photo")
//    , @NamedQuery(name = "ProductphotoEntity.findByProductId", query = "SELECT p FROM ProductphotoEntity p WHERE p.productId = :productId")
//    , @NamedQuery(name = "ProductphotoEntity.findByIsDefault", query = "SELECT p FROM ProductphotoEntity p WHERE p.isDefault = :isDefault")})
public class ProductphotoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @Column(name = "is_default")
    private Boolean isDefault;

    public ProductphotoEntity() {
    }

    public ProductphotoEntity(Integer id) {
        this.id = id;
    }

    public ProductphotoEntity(Integer id, String photo) {
        this.id = id;
        this.photo = photo;
    }

}
