package com.accenture.flowershop.Services.OrderService;

import com.accenture.flowershop.entity.OrderEntity;

import java.util.List;
import java.util.Map;

public interface OrderService {

    void createOrder(String login);

    List<OrderEntity> findOrder(Long id);

    Map<String, Object> payOrder(String login, long orderId) throws Exception;

    List<OrderEntity> getOrders(String login);
}
