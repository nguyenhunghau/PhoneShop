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
@Table(name = "productphoto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductphotoEntity.findAll", query = "SELECT p FROM ProductphotoEntity p")
    , @NamedQuery(name = "ProductphotoEntity.findById", query = "SELECT p FROM ProductphotoEntity p WHERE p.id = :id")
    , @NamedQuery(name = "ProductphotoEntity.findByPhoto", query = "SELECT p FROM ProductphotoEntity p WHERE p.photo = :photo")
    , @NamedQuery(name = "ProductphotoEntity.findByProductId", query = "SELECT p FROM ProductphotoEntity p WHERE p.productId = :productId")
    , @NamedQuery(name = "ProductphotoEntity.findByIsDefault", query = "SELECT p FROM ProductphotoEntity p WHERE p.isDefault = :isDefault")})
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
    @Column(name = "product_id")
    private Integer productId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
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
        if (!(object instanceof ProductphotoEntity)) {
            return false;
        }
        ProductphotoEntity other = (ProductphotoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.PhoneShop.entity.ProductphotoEntity[ id=" + id + " ]";
    }
    
}
