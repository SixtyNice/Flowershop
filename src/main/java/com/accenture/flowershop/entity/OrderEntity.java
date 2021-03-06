package com.accenture.flowershop.entity;

import com.accenture.flowershop.Enum.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class OrderEntity implements Serializable {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateCreate = new Date();
    private Date dateClose;
    @Enumerated(EnumType.STRING)
    @Column
    private OrderStatus status = OrderStatus.CREATED;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ElementCollection
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JoinOrderFlowersEntity> orderUserFlowers;

    public OrderEntity(UserEntity user) {
        this.user = user;
    }

    protected OrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<JoinOrderFlowersEntity> getOrderUserFlowers() {
        return orderUserFlowers;
    }

    public void setOrderUserFlowers(Set<JoinOrderFlowersEntity> orderUserFlowers) {
        this.orderUserFlowers = orderUserFlowers;
    }
}


//    @ManyToMany
//    @JoinTable(name = "Order_FLowers",
//            joinColumns = {@JoinColumn(name = "Order_ID")},
//            inverseJoinColumns = {@JoinColumn(name = " Flower_ID")})
//    @JoinColumn(name = "flower")
//    private List<FlowerEntity> flower;
