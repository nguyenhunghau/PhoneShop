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
@Table(name = "order_detail")
@Getter
@Setter
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "OrderDetailEntity.findAll", query = "SELECT o FROM OrderDetailEntity o")
//    , @NamedQuery(name = "OrderDetailEntity.findById", query = "SELECT o FROM OrderDetailEntity o WHERE o.id = :id")
//    , @NamedQuery(name = "OrderDetailEntity.findByOrderId", query = "SELECT o FROM OrderDetailEntity o WHERE o.orderId = :orderId")
//    , @NamedQuery(name = "OrderDetailEntity.findByProductId", query = "SELECT o FROM OrderDetailEntity o WHERE o.productId = :productId")
//    , @NamedQuery(name = "OrderDetailEntity.findByVariantId", query = "SELECT o FROM OrderDetailEntity o WHERE o.variantId = :variantId")
//    , @NamedQuery(name = "OrderDetailEntity.findByQuantity", query = "SELECT o FROM OrderDetailEntity o WHERE o.quantity = :quantity")})
public class OrderDetailEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private OrdersEntity ordersEntity;
    @Column(name = "order_id")
    private Integer orderId;

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

}
