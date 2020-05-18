package com.accenture.flowershop.Services.OrderService;

import com.accenture.flowershop.DAO.*;
import com.accenture.flowershop.DTO.OrderDTO;
import com.accenture.flowershop.Enum.OrderStatus;
import com.accenture.flowershop.Services.CartService.CartServiceImpl;
import com.accenture.flowershop.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OrderFlowerDAO orderFlowerDAO;

    @Autowired
    private JoinOrderFlowersDAO joinOrderFlowersDAO;

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private FlowerDAO flowerDAO;

    @Override
    @Transactional
    public OrderDTO createOrder(long userId) {
        Optional<UserEntity> user = userDAO.findById(userId);
        if (user.isPresent()) {
            Optional<CartEntity> userCart = cartDAO.findByUserId(user.get().getId());
            if (userCart.isPresent()) {
                OrderEntity order = new OrderEntity(user.get());
                BigDecimal totalPrice = new BigDecimal(0);
                for (JoinCartFlowersEntity cartFlowerEntity : userCart.get().getCartUserFlowers()) {
                    //save flower for order
                    OrderFlowerEntity orderFlowerEntity = new OrderFlowerEntity(cartFlowerEntity.getCartFlowerId());
                    orderFlowerDAO.save(orderFlowerEntity);

                    //save to join table
                    JoinOrderFlowersEntity flowerEntity = new JoinOrderFlowersEntity(orderFlowerEntity, order);
                    joinOrderFlowersDAO.save(flowerEntity);

                    //Money operations
                    //Find flower price
                    BigDecimal flowerPrice = cartFlowerEntity.getCartFlowerId().getFlower().getPrice();
                    //Calculate price of flowers
                    flowerPrice = flowerPrice.multiply(new BigDecimal(cartFlowerEntity.getCartFlowerId().getCartAmount()));
                    totalPrice = totalPrice.add(flowerPrice);
                }
                if (user.get().getDiscount() != 0) {
                    BigDecimal priceOfDiscount = totalPrice.multiply(BigDecimal.valueOf(user.get().getDiscount() / 100));
                    totalPrice = totalPrice.subtract(priceOfDiscount);
                }
                order.setPrice(totalPrice);
                orderDAO.save(order);
                cartService.clearCart(userId);
                return new OrderDTO(order);
            }
        }
        return null;
    }

    @Override
    public OrderDTO getOrder(long orderId) {
        Optional<OrderEntity> order = orderDAO.findById(orderId);
        if (order.isPresent()) {
            return new OrderDTO(order.get());
        }
        return null;
    }

    @Override
    public List<OrderDTO> getUserOrders(long userId) {
        Optional<UserEntity> user = userDAO.findById(userId);

        if (user.isPresent()) {
            List<OrderEntity> listOrders = orderDAO.findAllByUser(user.get());
            List<OrderDTO> orderDTOList = new ArrayList<>();
            for (OrderEntity orderEntity : listOrders) {
                orderDTOList.add(new OrderDTO(orderEntity));
            }
            return orderDTOList;
        }
        return null;

    }

    @Override
    public boolean payOrder(long userId, long orderId) {
        Optional<UserEntity> user = userDAO.findById(userId);
        if (user.isPresent()) {
            Optional<OrderEntity> order = orderDAO.findById(orderId);
            if (order.isPresent()) {
                BigDecimal userBalance = user.get().getBalance();
                BigDecimal orderPrice = order.get().getPrice();
                if (orderPrice.compareTo(userBalance) <= 0) {
                    userBalance = userBalance.subtract(orderPrice);
                    user.get().setBalance(userBalance);
                    userDAO.save(user.get());
                    order.get().setStatus(OrderStatus.PAID);
                    order.get().getOrderUserFlowers().forEach(orderFlower -> {
                        FlowerEntity flowerEntity = orderFlower.getOrderFlowerId().getFlower();
                        flowerEntity.setAmount(flowerEntity.getAmount() - orderFlower.getOrderFlowerId().getCartAmount());
                        flowerDAO.save(flowerEntity);
                    });
                    orderDAO.save(order.get());
                    return true;
                }
            }
        }
        return false;
    }


}
