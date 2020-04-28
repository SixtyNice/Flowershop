package com.accenture.flowershop.Controller;

import com.accenture.flowershop.Services.OrderService.OrderServiceImpl;
import com.accenture.flowershop.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("{login}/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping(path = "/createOrder", produces = "application/json", consumes = "application/json")
    public boolean createOrder(@PathVariable(value = "login") String login) {
        try {
            orderService.createOrder(login);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @GetMapping(path = "/{orderId}", produces = "application/json", consumes = "application/json")
    public List<OrderEntity> getOrder(@PathVariable(value = "orderId") Long orderId) {
        return orderService.findOrder(orderId);
    }

    @PostMapping(path = "/payOrder/{orderId}", produces = "application/json", consumes = "application/json")
    public Map<String, Object> payOrder(
            @PathVariable(value = "orderId") Long orderId,
            @PathVariable(value = "login") String login) {
        return orderService.payOrder(login, orderId);
    }

}
