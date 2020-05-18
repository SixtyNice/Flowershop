package com.accenture.flowershop.Services.AdminService;

import com.accenture.flowershop.entity.OrderEntity;

import java.util.List;

public interface AdminService {

    List<OrderEntity> loadOrders();

    boolean closeOrder(long orderId);

}
