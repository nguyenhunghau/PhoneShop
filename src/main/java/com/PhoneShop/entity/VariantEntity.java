/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PhoneShop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "variant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VariantEntity.findAll", query = "SELECT v FROM VariantEntity v")
    , @NamedQuery(name = "VariantEntity.findById", query = "SELECT v FROM VariantEntity v WHERE v.id = :id")
    , @NamedQuery(name = "VariantEntity.findByName", query = "SELECT v FROM VariantEntity v WHERE v.name = :name")
    , @NamedQuery(name = "VariantEntity.findByProductId", query = "SELECT v FROM VariantEntity v WHERE v.productId = :productId")
    , @NamedQuery(name = "VariantEntity.findByCategory", query = "SELECT v FROM VariantEntity v WHERE v.category = :category")
    , @NamedQuery(name = "VariantEntity.findByPrice", query = "SELECT v FROM VariantEntity v WHERE v.price = :price")})
public class VariantEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "category")
    private String category;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;

    public VariantEntity() {
    }

    public VariantEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VariantEntity)) {
            return false;
        }
        VariantEntity other = (VariantEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.PhoneShop.entity.VariantEntity[ id=" + id + " ]";
    }
    
}
