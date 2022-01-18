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
@Table(name = "categorydetail")
@Getter
@Setter
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "CategorydetailEntity.findAll", query = "SELECT c FROM CategorydetailEntity c")
//    , @NamedQuery(name = "CategorydetailEntity.findById", query = "SELECT c FROM CategorydetailEntity c WHERE c.id = :id")
//    , @NamedQuery(name = "CategorydetailEntity.findByName", query = "SELECT c FROM CategorydetailEntity c WHERE c.name = :name")
//    , @NamedQuery(name = "CategorydetailEntity.findByCategoryId", query = "SELECT c FROM CategorydetailEntity c WHERE c.categoryId = :categoryId")})
public class CategorydetailEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    public CategorydetailEntity() {
    }

    public CategorydetailEntity(Integer id) {
        this.id = id;
    }

}
