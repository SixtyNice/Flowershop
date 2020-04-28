package com.accenture.flowershop.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CART")
public class CartEntity {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount")
    private Integer amount;

//    @ManyToMany
//    @JoinTable(name = "CartFlowers",
//            joinColumns = {@JoinColumn(name = "Flower_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "Cart_ID")})
//    @JoinColumn(name = "flower")
//    private Set<FlowerEntity> flowerId;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "flower_id", nullable = false)
    private FlowerEntity flower;

    protected CartEntity() {

    }

    public CartEntity(Integer amount, FlowerEntity flower, UserEntity user) {
        this.user = user;
        this.amount = amount;
        this.flower = flower;
    }

    public FlowerEntity getFlower() {
        return flower;
    }

    public void setFlower(FlowerEntity flower) {
        this.flower = flower;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", amount=" + amount +
                ", user=" + user.getLogin() +
                ", flower=" + flower.getName() +
                '}';
    }
}
