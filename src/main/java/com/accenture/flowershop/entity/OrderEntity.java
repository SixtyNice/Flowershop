package com.accenture.flowershop.entity;

import com.accenture.flowershop.Enum.OrderStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private Date dateCreate;
    private Date dateClose;
    @Enumerated(EnumType.STRING)
    @Column
    private OrderStatus status = OrderStatus.CREATED;
    private Integer amount;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToMany
    @JoinTable(name = "OrderFLowers",
            joinColumns = {@JoinColumn(name = "Order_ID")},
            inverseJoinColumns = {@JoinColumn(name = " Flower_ID")})
    @JoinColumn(name = "flower")
    private Set<FlowerEntity> flower;



    public OrderEntity(CartEntity cart) {
//        this.amount = cart.getAmount();
        this.user = cart.getUser();
        this.flower = cart.getFlower();
        dateCreate = new Date();
    }

    protected OrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Set<FlowerEntity> getFlower() {
        return flower;
    }

    public void setFlower(Set<FlowerEntity> flower) {
        this.flower = flower;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
