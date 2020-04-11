package com.accenture.flowershop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FLOWERS")
public class FlowerEntity {

    @Id
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "AMOUNT")
    private int amount;

    protected FlowerEntity() {
    }

    public FlowerEntity(String name, int price, int amount) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
