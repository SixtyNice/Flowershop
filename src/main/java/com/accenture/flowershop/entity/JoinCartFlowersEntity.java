package com.accenture.flowershop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Join_Cart_Flowers")
public class JoinCartFlowersEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Cart_Flower")
    private CartFlowerEntity cartFlowerId;

    @ManyToOne()
    @JoinColumn(name = "Cart_Id")
    @JsonBackReference
    private CartEntity cart;


    protected JoinCartFlowersEntity() {
    }

    public JoinCartFlowersEntity(CartEntity cart, CartFlowerEntity cartFlowerId) {
        this.cart = cart;
        this.cartFlowerId = cartFlowerId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    public CartFlowerEntity getCartFlowerId() {
        return cartFlowerId;
    }

    public void setCartFlowerId(CartFlowerEntity cartFlowerId) {
        this.cartFlowerId = cartFlowerId;
    }
}
