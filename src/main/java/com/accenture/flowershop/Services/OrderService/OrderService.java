package com.accenture.flowershop.Services.OrderService;

import com.accenture.flowershop.DTO.OrderDTO;
import com.accenture.flowershop.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder(long userId);

    OrderDTO getOrder(long orderId);

    List<OrderDTO> getUserOrders(long userId);

    boolean payOrder(long userId,long orderId);

}
