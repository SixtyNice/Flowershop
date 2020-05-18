package com.accenture.flowershop.DTO;

import com.accenture.flowershop.entity.UserEntity;

import java.math.BigDecimal;

public class UserDTO {
    private Long id;
    private String login;
    private String name;
    private String lastName;
    private String middleName;
    private String address;
    private BigDecimal balance;
    private Double discount;

    public UserDTO(UserEntity user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.middleName = user.getMiddleName();
        this.address = user.getAddress();
        this.balance = user.getBalance();
        this.discount = user.getDiscount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
