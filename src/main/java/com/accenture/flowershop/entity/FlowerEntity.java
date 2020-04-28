package com.accenture.flowershop.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "FLOWERS")
public class FlowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private BigDecimal price;
    private Integer amount;

    @OneToMany(mappedBy = "flower", cascade = CascadeType.ALL)
    private List<CartEntity> cart;

    @OneToMany(mappedBy = "flower", cascade = CascadeType.ALL)
    private List<OrderEntity> order;

    protected FlowerEntity() {
    }

    public FlowerEntity(Long id, String name, BigDecimal price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "FlowerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
