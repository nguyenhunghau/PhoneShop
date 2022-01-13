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
@Table(name = "order_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetailEntity.findAll", query = "SELECT o FROM OrderDetailEntity o")
    , @NamedQuery(name = "OrderDetailEntity.findById", query = "SELECT o FROM OrderDetailEntity o WHERE o.id = :id")
    , @NamedQuery(name = "OrderDetailEntity.findByOrderId", query = "SELECT o FROM OrderDetailEntity o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "OrderDetailEntity.findByProductId", query = "SELECT o FROM OrderDetailEntity o WHERE o.productId = :productId")
    , @NamedQuery(name = "OrderDetailEntity.findByVariantId", query = "SELECT o FROM OrderDetailEntity o WHERE o.variantId = :variantId")
    , @NamedQuery(name = "OrderDetailEntity.findByQuantity", query = "SELECT o FROM OrderDetailEntity o WHERE o.quantity = :quantity")})
public class OrderDetailEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "variant_id")
    private Integer variantId;
    @Column(name = "quantity")
    private Integer quantity;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(Integer id) {
        this.id = id;
    }

    public OrderDetailEntity(Integer id, int orderId) {
        this.id = id;
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getVariantId() {
        return variantId;
    }

    public void setVariantId(Integer variantId) {
        this.variantId = variantId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        if (!(object instanceof OrderDetailEntity)) {
            return false;
        }
        OrderDetailEntity other = (OrderDetailEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.PhoneShop.entity.OrderDetailEntity[ id=" + id + " ]";
    }
    
}
