package com.accenture.flowershop.entity;

import javax.persistence.Column;
import javax.persistence.OneToOne;

public class CartEntity {

    String flowerName;

    

    @OneToOne
    private UserEntity user;


}
