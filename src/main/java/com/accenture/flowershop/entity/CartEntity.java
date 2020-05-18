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


    @ElementCollection
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JoinCartFlowersEntity> cartUserFlowers;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;


    protected CartEntity() {

    }

    public CartEntity(UserEntity user) {

        this.user = user;
    }

    public Set<JoinCartFlowersEntity> getCartUserFlowers() {
        return cartUserFlowers;
    }

    public void setCartUserFlowers(Set<JoinCartFlowersEntity> cartUserFlowers) {
        this.cartUserFlowers = cartUserFlowers;
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

//    @JoinTable(name = "CartFlowers",
//
//            inverseJoinColumns = {@JoinColumn(name = "Flower_ID")}
//    )

//    @ElementCollection
//    @ManyToMany()
//    @JoinTable(name = "Cart_Flowers",
//            joinColumns = {@JoinColumn(name = "Cart_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "Flower_ID")})
//    private Set<FlowerEntity> flower;
//    @ElementCollection

//    @ElementCollection
//    @ManyToMany(cascade = CascadeType.REMOVE)
//    @JoinTable(name = "Cart_User_Flowers",
//            joinColumns = {@JoinColumn(name = "Cart_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "Cart_Flower_ID")})
//    private Set<CartFlower> CartFlower;

//    @OneToMany
//    @JoinColumn(name = "flower_id")
//    private List<FlowerEntity> flower = new ArrayList<>();

//    @OneToMany(mappedBy = "cart")
//    private Set<CartFlowersEntity> flowersCart;
