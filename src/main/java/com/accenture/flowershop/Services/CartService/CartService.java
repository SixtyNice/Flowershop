package com.accenture.flowershop.Services.CartService;

import com.accenture.flowershop.entity.CartEntity;
import com.accenture.flowershop.entity.FlowerEntity;

import java.util.List;
import java.util.Set;

public interface CartService {

    String addToCart(String login, Set<FlowerEntity> flower);

    void deleteFromCart(String login,FlowerEntity flower);

    void clearCart(String login);

    CartEntity getCart(String login);

}
