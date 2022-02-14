/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PhoneShop.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "reviews")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "ReviewsEntity.findAll", query = "SELECT r FROM ReviewsEntity r")
//    , @NamedQuery(name = "ReviewsEntity.findById", query = "SELECT r FROM ReviewsEntity r WHERE r.id = :id")
//    , @NamedQuery(name = "ReviewsEntity.findByScore", query = "SELECT r FROM ReviewsEntity r WHERE r.score = :score")
//    , @NamedQuery(name = "ReviewsEntity.findByName", query = "SELECT r FROM ReviewsEntity r WHERE r.name = :name")
//    , @NamedQuery(name = "ReviewsEntity.findByEmail", query = "SELECT r FROM ReviewsEntity r WHERE r.email = :email")
//    , @NamedQuery(name = "ReviewsEntity.findByProductId", query = "SELECT r FROM ReviewsEntity r WHERE r.productId = :productId")
//    , @NamedQuery(name = "ReviewsEntity.findByNewsId", query = "SELECT r FROM ReviewsEntity r WHERE r.newsId = :newsId")
//    , @NamedQuery(name = "ReviewsEntity.findByCreatedDate", query = "SELECT r FROM ReviewsEntity r WHERE r.createdDate = :createdDate")})
public class ReviewsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "score")
    private Integer score;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "news_id")
    private Integer newsId;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public ReviewsEntity() {
    }

    public ReviewsEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
        if (!(object instanceof ReviewsEntity)) {
            return false;
        }
        ReviewsEntity other = (ReviewsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.PhoneShop.entity.ReviewsEntity[ id=" + id + " ]";
    }
    
}
