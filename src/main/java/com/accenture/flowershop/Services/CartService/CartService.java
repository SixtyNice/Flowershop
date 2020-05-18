package com.accenture.flowershop.Services.CartService;

import com.accenture.flowershop.DTO.CartDTO;
import com.accenture.flowershop.entity.CartEntity;
import com.accenture.flowershop.entity.FlowerEntity;

public interface CartService {

    String addToCart(long userId, FlowerEntity flower);

    boolean deleteFromCart(long id);

    boolean clearCart(long id);

    CartDTO getCart(long userId);

}
