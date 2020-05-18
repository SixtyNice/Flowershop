package com.accenture.flowershop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "FLOWERS")
public class FlowerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private BigDecimal price;
    private Integer amount;

//        @ManyToOne
//    private List<CartEntity> cart = new ArrayList<>();

    @OneToMany(mappedBy = "flower")
    private List<CartFlowerEntity> cartFlowerEntities;


//    @OneToMany(mappedBy = "flower", cascade = CascadeType.ALL)
//    private List<OrderEntity> order;
//    @OneToMany(mappedBy = "flower")
//    private Set<CartFlowersEntity> flowersCart;

    protected FlowerEntity() {
    }

    public FlowerEntity(Long id, String name, BigDecimal price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public FlowerEntity(FlowerEntity flower, Integer amount) {
        this.id = flower.getId();
        this.name = flower.getName();
        this.price = flower.getPrice();
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
