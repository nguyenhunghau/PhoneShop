/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PhoneShop.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdersEntity.findAll", query = "SELECT o FROM OrdersEntity o")
    , @NamedQuery(name = "OrdersEntity.findById", query = "SELECT o FROM OrdersEntity o WHERE o.id = :id")
    , @NamedQuery(name = "OrdersEntity.findByUserId", query = "SELECT o FROM OrdersEntity o WHERE o.userId = :userId")
    , @NamedQuery(name = "OrdersEntity.findByOrderDate", query = "SELECT o FROM OrdersEntity o WHERE o.orderDate = :orderDate")
    , @NamedQuery(name = "OrdersEntity.findByAddress", query = "SELECT o FROM OrdersEntity o WHERE o.address = :address")
    , @NamedQuery(name = "OrdersEntity.findByShipDate", query = "SELECT o FROM OrdersEntity o WHERE o.shipDate = :shipDate")
    , @NamedQuery(name = "OrdersEntity.findByShipCost", query = "SELECT o FROM OrdersEntity o WHERE o.shipCost = :shipCost")
    , @NamedQuery(name = "OrdersEntity.findByPromotionCode", query = "SELECT o FROM OrdersEntity o WHERE o.promotionCode = :promotionCode")})
public class OrdersEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "address")
    private String address;
    @Column(name = "ship_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ship_cost")
    private Double shipCost;
    @Column(name = "promotion_code")
    private String promotionCode;

    public OrdersEntity() {
    }

    public OrdersEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Double getShipCost() {
        return shipCost;
    }

    public void setShipCost(Double shipCost) {
        this.shipCost = shipCost;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
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
        if (!(object instanceof OrdersEntity)) {
            return false;
        }
        OrdersEntity other = (OrdersEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.PhoneShop.entity.OrdersEntity[ id=" + id + " ]";
    }
    
}
