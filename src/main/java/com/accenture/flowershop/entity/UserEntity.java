package com.accenture.flowershop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer balance;

    @Column(nullable = false)
    private Integer discount;

    protected UserEntity() {
    }


    public UserEntity(String login, String name, String lastName, String middleName, String address) {
        this.login = login;
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Login " + this.login + " Name: " + this.name + " Last Name: "
                + this.lastName + " Middle Name: " + this.middleName
                + " Address: " + this.address;

    }

    public void setCart(Cart cart) {
        if (cart == null) {
            if (this.cart != null) {
                this.cart.setUser(null);
            }
        } else {
            cart.setUser(this);
        }
        this.cart = cart;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
