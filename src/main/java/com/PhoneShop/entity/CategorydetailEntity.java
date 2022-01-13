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
@Table(name = "categorydetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategorydetailEntity.findAll", query = "SELECT c FROM CategorydetailEntity c")
    , @NamedQuery(name = "CategorydetailEntity.findById", query = "SELECT c FROM CategorydetailEntity c WHERE c.id = :id")
    , @NamedQuery(name = "CategorydetailEntity.findByName", query = "SELECT c FROM CategorydetailEntity c WHERE c.name = :name")
    , @NamedQuery(name = "CategorydetailEntity.findByCategoryId", query = "SELECT c FROM CategorydetailEntity c WHERE c.categoryId = :categoryId")})
public class CategorydetailEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "category_id")
    private Integer categoryId;

    public CategorydetailEntity() {
    }

    public CategorydetailEntity(Integer id) {
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
        if (!(object instanceof CategorydetailEntity)) {
            return false;
        }
        CategorydetailEntity other = (CategorydetailEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.PhoneShop.entity.CategorydetailEntity[ id=" + id + " ]";
    }
    
}
