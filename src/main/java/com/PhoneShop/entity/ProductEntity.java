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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductEntity.findAll", query = "SELECT p FROM ProductEntity p")
    , @NamedQuery(name = "ProductEntity.findById", query = "SELECT p FROM ProductEntity p WHERE p.id = :id")
    , @NamedQuery(name = "ProductEntity.findByCode", query = "SELECT p FROM ProductEntity p WHERE p.code = :code")
    , @NamedQuery(name = "ProductEntity.findByName", query = "SELECT p FROM ProductEntity p WHERE p.name = :name")
    , @NamedQuery(name = "ProductEntity.findByCategoryDetailId", query = "SELECT p FROM ProductEntity p WHERE p.categoryDetailId = :categoryDetailId")
    , @NamedQuery(name = "ProductEntity.findByProducerId", query = "SELECT p FROM ProductEntity p WHERE p.producerId = :producerId")
    , @NamedQuery(name = "ProductEntity.findByPrice", query = "SELECT p FROM ProductEntity p WHERE p.price = :price")
    , @NamedQuery(name = "ProductEntity.findByIsImportant", query = "SELECT p FROM ProductEntity p WHERE p.isImportant = :isImportant")})
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "parameter")
    private String parameter;
    @Lob
    @Column(name = "detail")
    private String detail;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "category_detail_id")
    private Integer categoryDetailId;
    @Column(name = "producer_id")
    private Integer producerId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "is_important")
    private Boolean isImportant;

    public ProductEntity() {
    }

    public ProductEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryDetailId() {
        return categoryDetailId;
    }

    public void setCategoryDetailId(Integer categoryDetailId) {
        this.categoryDetailId = categoryDetailId;
    }

    public Integer getProducerId() {
        return producerId;
    }

    public void setProducerId(Integer producerId) {
        this.producerId = producerId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(Boolean isImportant) {
        this.isImportant = isImportant;
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
        if (!(object instanceof ProductEntity)) {
            return false;
        }
        ProductEntity other = (ProductEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.PhoneShop.entity.ProductEntity[ id=" + id + " ]";
    }
    
}
