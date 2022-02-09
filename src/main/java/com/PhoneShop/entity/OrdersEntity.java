/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PhoneShop.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "OrdersEntity.findAll", query = "SELECT o FROM OrdersEntity o")
//    , @NamedQuery(name = "OrdersEntity.findById", query = "SELECT o FROM OrdersEntity o WHERE o.id = :id")
//    , @NamedQuery(name = "OrdersEntity.findByUserId", query = "SELECT o FROM OrdersEntity o WHERE o.userId = :userId")
//    , @NamedQuery(name = "OrdersEntity.findByOrderDate", query = "SELECT o FROM OrdersEntity o WHERE o.orderDate = :orderDate")
//    , @NamedQuery(name = "OrdersEntity.findByAddress", query = "SELECT o FROM OrdersEntity o WHERE o.address = :address")
//    , @NamedQuery(name = "OrdersEntity.findByShipDate", query = "SELECT o FROM OrdersEntity o WHERE o.shipDate = :shipDate")
//    , @NamedQuery(name = "OrdersEntity.findByShipCost", query = "SELECT o FROM OrdersEntity o WHERE o.shipCost = :shipCost")
//    , @NamedQuery(name = "OrdersEntity.findByPromotionCode", query = "SELECT o FROM OrdersEntity o WHERE o.promotionCode = :promotionCode")})
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

//    @OneToMany(mappedBy = "ordersEntity")
//    private List<OrderDetailEntity> orderDetailEntityList;

    public OrdersEntity() {
    }

    public OrdersEntity(Integer id) {
        this.id = id;
    }

}
