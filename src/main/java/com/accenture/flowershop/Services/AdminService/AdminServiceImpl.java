package com.accenture.flowershop.Services.AdminService;

import com.accenture.flowershop.DAO.OrderDAO;
import com.accenture.flowershop.Enum.OrderStatus;
import com.accenture.flowershop.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public List<OrderEntity> loadOrders() {

        return orderDAO.findByOrderByDateCreate();

    }

    @Override
    @Transactional
    public boolean closeOrder(long orderId) {
        Optional<OrderEntity> order = orderDAO.findById(orderId);
        if (order.isPresent()) {
            order.get().setStatus(OrderStatus.CLOSED);
            order.get().setDateClose(new Date());
            orderDAO.save(order.get());
            return true;
        }

        return false;
    }
}
