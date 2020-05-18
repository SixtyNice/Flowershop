package com.accenture.flowershop.DTO;

import com.accenture.flowershop.entity.CartEntity;
import com.accenture.flowershop.entity.JoinCartFlowersEntity;

import java.util.Set;

public class CartDTO {
    private Set<JoinCartFlowersEntity> cartUserFlowersEntities;

    public CartDTO(CartEntity cartEntity) {
        this.cartUserFlowersEntities = cartEntity.getCartUserFlowers();
    }

    public Set<JoinCartFlowersEntity> getCartUserFlowersEntities() {
        return cartUserFlowersEntities;
    }

    public void setCartUserFlowersEntities(Set<JoinCartFlowersEntity> cartUserFlowersEntities) {
        this.cartUserFlowersEntities = cartUserFlowersEntities;
    }
}
