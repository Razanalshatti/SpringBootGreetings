package com.letcode.SecureBankSystem.entity;

import com.letcode.SecureBankSystem.util.enums.Roles;
import com.letcode.SecureBankSystem.util.enums.Status;

import javax.persistence.*;

@Entity
@Table(name = "Bank_users")

public class UserEntity {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private java.lang.String name;
    @Column(name = "phone_number",nullable = false)

    private java.lang.String phoneNumber;
    @Column(name = "email",nullable = false)

    private java.lang.String email;



    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private Status status;


    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    @Enumerated(EnumType.STRING)
    @OneToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;


    @Column(nullable = false)
    private String password;
    @Column(name = "username",nullable = false)
    private String username;
    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(java.lang.String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}