/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PhoneShop.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "product")
@Getter
@Setter
@XmlRootElement
@NamedQueries({
//    @NamedQuery(name = "ProductEntity.findAll", query = "SELECT p FROM ProductEntity p")
//    , @NamedQuery(name = "ProductEntity.findById", query = "SELECT p FROM ProductEntity p WHERE p.id = :id")
//    , @NamedQuery(name = "ProductEntity.findByCode", query = "SELECT p FROM ProductEntity p WHERE p.code = :code")
//    , @NamedQuery(name = "ProductEntity.findByName", query = "SELECT p FROM ProductEntity p WHERE p.name = :name")
@NamedQuery(name = "ProductEntity.findByCategory", query = "SELECT p FROM ProductEntity p WHERE p.categorydetailEntity.categoryEntity.id = :categoryId"),
@NamedQuery(name = "ProductEntity.findImportantsByCategory", query = "SELECT p FROM ProductEntity p WHERE p.categorydetailEntity.categoryEntity.id = :categoryId and p.isImportant=true"),
@NamedQuery(name = "ProductEntity.findByCategoryWithSortASC", query = "SELECT p FROM ProductEntity p WHERE p.categorydetailEntity.categoryEntity.id = :categoryId order by p.price"),
@NamedQuery(name = "ProductEntity.findByCategoryWithSortDESC", query = "SELECT p FROM ProductEntity p WHERE p.categorydetailEntity.categoryEntity.id = :categoryId order by p.price desc"),
@NamedQuery(name = "ProductEntity.findByCategoryWithSortByDateDESC", query = "SELECT p FROM ProductEntity p WHERE p.categorydetailEntity.categoryEntity.id = :categoryId order by p.productLaunchDate desc"),
//    , @NamedQuery(name = "ProductEntitydesc.findByProducerId", query = "SELECT p FROM ProductEntity p WHERE p.producerId = :producerId")
//    , @NamedQuery(name = "ProductEntity.findByPrice", query = "SELECT p FROM ProductEntity p WHERE p.price = :price")
//    , @NamedQuery(name = "ProductEntity.findByIsImportant", query = "SELECT p FROM ProductEntity p WHERE p.isImportant = :isImportant")
})
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
    @Lob
    @Temporal(TemporalType.DATE)
    @Column(name = "product_launch_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productLaunchDate;


    @ManyToOne
    @JoinColumn(name = "category_detail_id")
    private CategorydetailEntity categorydetailEntity;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private ProducerEntity producerEntity;

    @Column(name = "price")
    private Double price;
    @Column(name = "is_important")
    private Boolean isImportant;

    @OneToMany(mappedBy="productEntity")
    private List<ProductphotoEntity> productphotoEntityList;

    @OneToMany(mappedBy="productEntity")
    private List<VariantEntity> variantEntityList;

    public ProductEntity() {
    }

    public ProductEntity(Integer id) {
        this.id = id;
    }
}
