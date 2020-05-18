package com.accenture.flowershop.entity;

import javax.persistence.*;

@Entity
@Table(name = "Order_Flower")
public class OrderFlowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne()
    private FlowerEntity flower;
    private Integer cartAmount;

    protected OrderFlowerEntity() {
    }

    public OrderFlowerEntity(CartFlowerEntity cartFlowerEntity) {
        this.flower = cartFlowerEntity.getFlower();
        this.cartAmount = cartFlowerEntity.getCartAmount();
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
