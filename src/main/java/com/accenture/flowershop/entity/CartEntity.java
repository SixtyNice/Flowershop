package com.accenture.flowershop.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CART")
public class CartEntity {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name = "amount")
//    private Integer amount;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CartFlowers",
            joinColumns = {@JoinColumn(name = "Cart_ID")},
            inverseJoinColumns = {@JoinColumn(name = " Flower_ID")})
    @JoinColumn(name = "flower")
    @ElementCollection
    private Set<FlowerEntity> flower;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

//    @OneToMany
//    @JoinColumn(name = "flower_id")
//    private List<FlowerEntity> flower = new ArrayList<>();


    protected CartEntity() {

    }

//    public CartEntity(Integer amount, Set<FlowerEntity> flower, UserEntity user) {
//        this.user = user;
//        this.amount = amount;
//        this.flower = flower;
//    }

    public CartEntity(Set<FlowerEntity> flower, UserEntity user) {
        this.flower = flower;
        this.user = user;
    }

    public Set<FlowerEntity> getFlower() {
        return flower;
    }

    public void setFlower(Set<FlowerEntity> flower) {
        this.flower = flower;
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

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", user=" + user.getLogin() +
                '}';
    }
}
