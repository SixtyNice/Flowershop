package com.accenture.flowershop.DTO;

import com.accenture.flowershop.Enum.OrderStatus;
import com.accenture.flowershop.entity.JoinOrderFlowersEntity;
import com.accenture.flowershop.entity.OrderEntity;
import com.accenture.flowershop.entity.UserEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class OrderDTO {

    private Long id;
    private Date dateCreate;
    private Date dateClose;

    private OrderStatus status = OrderStatus.CREATED;
    private BigDecimal price;

    private Set<JoinOrderFlowersEntity> orderUserFlowers;

    public OrderDTO(OrderEntity orderEntity) {
        this.id = orderEntity.getId();
        this.dateCreate = orderEntity.getDateCreate();
        this.dateClose = orderEntity.getDateClose();
        this.status = orderEntity.getStatus();
        this.price = orderEntity.getPrice();
        this.orderUserFlowers = orderEntity.getOrderUserFlowers();
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
