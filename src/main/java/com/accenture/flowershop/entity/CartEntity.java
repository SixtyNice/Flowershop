package com.accenture.flowershop.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "flower_name")
    private String flowerName;


    @OneToOne()
    @JoinColumn(name = "user_id")
    @MapsId
    UserEntity user;


    protected Cart() {

    }

    public Cart(String flowerName) {
        this.flowerName = flowerName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }
}
