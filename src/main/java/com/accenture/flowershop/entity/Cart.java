package com.accenture.flowershop.entity;

import javax.persistence.*;

@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount")
    Integer amount;

    @Column(name = "flower_name")
    String flowerName;


    @OneToOne()
    @JoinColumn(name = "user_id")
    UserEntity user;

    protected Cart() {
    }

    public Cart(String flowerName) {
        this.flowerName = flowerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
