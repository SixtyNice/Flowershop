package com.accenture.flowershop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Cart_Flower")
public class CartFlowerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne()
    private FlowerEntity flower;
    private Integer cartAmount;

    protected CartFlowerEntity() {
    }

    public CartFlowerEntity(FlowerEntity flower, Integer cartAmount) {
        this.flower = flower;
        this.cartAmount = cartAmount;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public FlowerEntity getFlower() {
        return flower;
    }

    public void setFlower(FlowerEntity flower) {
        this.flower = flower;
    }

    public Integer getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(Integer cartAmount) {
        this.cartAmount = cartAmount;
    }
}
