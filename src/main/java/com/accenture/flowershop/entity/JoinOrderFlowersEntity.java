package com.accenture.flowershop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Join_Order_Flowers")
public class JoinOrderFlowersEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Order_Flower")
    private OrderFlowerEntity orderFlowerId;

    @ManyToOne()
    @JoinColumn(name = "Order_Id")
    @JsonBackReference
    private OrderEntity order;

    protected JoinOrderFlowersEntity(){}

    public JoinOrderFlowersEntity(OrderFlowerEntity orderFlowerId, OrderEntity order) {
        this.orderFlowerId = orderFlowerId;
        this.order = order;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public OrderFlowerEntity getOrderFlowerId() {
        return orderFlowerId;
    }

    public void setOrderFlowerId(OrderFlowerEntity orderFlowerId) {
        this.orderFlowerId = orderFlowerId;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
