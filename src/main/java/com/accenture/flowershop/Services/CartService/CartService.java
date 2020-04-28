package com.accenture.flowershop.Services.CartService;

import com.accenture.flowershop.entity.CartEntity;
import com.accenture.flowershop.entity.FlowerEntity;

import java.util.List;

public interface CartService {

    String addToCart(String login, FlowerEntity flower);

    void deleteFromCart(String login,FlowerEntity flower);

    void clearCart(String login);

    List<CartEntity> getCart(String login);

}
