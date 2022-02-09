/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PhoneShop.entity;

import lombok.Getter;
import lombok.Setter;

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
@Table(name = "user")
@Getter
@Setter
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u")
//    , @NamedQuery(name = "UserEntity.findById", query = "SELECT u FROM UserEntity u WHERE u.id = :id")
//    , @NamedQuery(name = "UserEntity.findByFirstname", query = "SELECT u FROM UserEntity u WHERE u.firstname = :firstname")
//    , @NamedQuery(name = "UserEntity.findByLastname", query = "SELECT u FROM UserEntity u WHERE u.lastname = :lastname")
//    , @NamedQuery(name = "UserEntity.findByUsername", query = "SELECT u FROM UserEntity u WHERE u.username = :username")
//    , @NamedQuery(name = "UserEntity.findByEmail", query = "SELECT u FROM UserEntity u WHERE u.email = :email")
//    , @NamedQuery(name = "UserEntity.findByGender", query = "SELECT u FROM UserEntity u WHERE u.gender = :gender")
//    , @NamedQuery(name = "UserEntity.findByPassword", query = "SELECT u FROM UserEntity u WHERE u.password = :password")
//    , @NamedQuery(name = "UserEntity.findByRole", query = "SELECT u FROM UserEntity u WHERE u.role = :role")})
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private Boolean gender;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role; 
    @Column(name = "session_id")
    private String sessionId;

    public UserEntity() {
    }

    public UserEntity(Integer id) {
        this.id = id;
    }

    public UserEntity(Integer id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
