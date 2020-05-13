//package com.accenture.flowershop.Services.AdminService;
//
//import com.accenture.flowershop.DAO.OrderDAO;
//import com.accenture.flowershop.entity.OrderEntity;
//import com.accenture.flowershop.Enum.OrderStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class AdminServiceImpl implements AdminService {
//
//    @Autowired
//    private OrderDAO orderDAO;
//
//    @Override
//    public List<OrderEntity> loadOrders() {
//        List<OrderEntity> orders = orderDAO.findAll();
//
////        Sort for date - new first
//        orders.sort((o1, o2) -> o2.getDateCreate().compareTo(o1.getDateCreate()));
//
//        return orders;
//
//    }
//
//    @Override
//    @Transactional
//    public List<OrderEntity> closeOrder(long orderId) {
//        List<OrderEntity> order = orderDAO.findByOrderId(orderId);
//        order.forEach(orderEntity -> {
//            orderEntity.setStatus(OrderStatus.CLOSED);
//            orderEntity.setDateClose(new Date());
//        });
//        return order;
//    }
//}
