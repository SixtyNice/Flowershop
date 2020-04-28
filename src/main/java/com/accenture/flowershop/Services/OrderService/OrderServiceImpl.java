package com.accenture.flowershop.Services.OrderService;

import com.accenture.flowershop.DAO.CartDAO;
import com.accenture.flowershop.DAO.OrderDAO;
import com.accenture.flowershop.DAO.UserDAO;
import com.accenture.flowershop.entity.CartEntity;
import com.accenture.flowershop.entity.OrderEntity;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import static java.lang.System.out;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private UserDAO userDAO;


    @Override
    @Transactional
    public void createOrder(String login) {
        try {
            UserEntity user = userDAO.findUserByLogin(login);
            List<CartEntity> userCart = cartDAO.findByUserId(user.getId());
            Random rnd = new Random(new Date().getTime());
            long orderId = Math.abs(rnd.nextLong());

            out.println("Order Id: " + orderId);
            for (CartEntity cart : userCart) {
                BigDecimal priceOfFlower = cart.getFlower().getPrice();
                BigDecimal totalPriceWithoutDiscount = priceOfFlower.multiply(new BigDecimal(cart.getAmount()));
                BigDecimal totalPrice;
                if (user.getDiscount() != 0) {
                    BigDecimal priceOfDiscount = totalPriceWithoutDiscount.multiply(new BigDecimal(user.getDiscount() / 100));
                    totalPrice = totalPriceWithoutDiscount.subtract(priceOfDiscount);
                } else {
                    totalPrice = totalPriceWithoutDiscount;
                }
                OrderEntity order = new OrderEntity(cart);
                order.setOrderId(orderId);
                order.setPrice(totalPrice);
                orderDAO.save(order);
            }
            cartDAO.clearCart(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<OrderEntity> findOrder(Long id) {
        List<OrderEntity> order = orderDAO.findByOrderId(id);
        for (OrderEntity item : order) {
            item.setUser(null);
        }
        return order;
    }

    @Override
    @Transactional
    public Map<String, Object> payOrder(String login, long orderId) {
        Map<String, Object> response = new TreeMap<>();
        List<OrderEntity> order = orderDAO.findByOrderId(orderId);

        UserEntity user = userDAO.findUserByLogin(login);
        BigDecimal userBalance = user.getBalance();
        BigDecimal totalPrice = new BigDecimal(0);

        boolean paid = false;

        for (OrderEntity orderItem : order) {
            totalPrice = totalPrice.add(orderItem.getPrice());
        }
        out.println("Price: " + totalPrice);

        if (totalPrice.compareTo(user.getBalance()) <= 0) {
            BigDecimal userBalanceAfterPay = userBalance.subtract(totalPrice);
            user.setBalance(userBalanceAfterPay);
            order.forEach(orderEntity -> orderEntity.setStatus("paid"));
            paid = true;
            response.put("balance", userBalanceAfterPay);
        }
        response.put("paid", paid);
        return response;
    }


    @Override
    public List<OrderEntity> getOrders(String login) {
        return null;
    }
}
