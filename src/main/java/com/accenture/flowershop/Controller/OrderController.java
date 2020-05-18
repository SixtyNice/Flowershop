package com.accenture.flowershop.Controller;

import com.accenture.flowershop.DTO.OrderDTO;
import com.accenture.flowershop.Services.OrderService.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("{userId}/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping(path = "/createOrder", produces = "application/json")
    public ResponseEntity<OrderDTO> createOrder(@PathVariable(value = "userId") long userId) {
        OrderDTO order = orderService.createOrder(userId);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/list", produces = "application/json")
    public ResponseEntity<List<OrderDTO>> getUserOrders(@PathVariable(value = "userId") long userId) {
        List<OrderDTO> orderDTOList = orderService.getUserOrders(userId);
        if (orderDTOList != null) {
            return new ResponseEntity<>(orderDTOList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }


    @GetMapping(path = "/{orderId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable(value = "orderId") Long orderId) {
        OrderDTO orderDTO = orderService.getOrder(orderId);
        if (orderDTO != null) {
            return new ResponseEntity<>(orderDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/payOrder/{orderId}", produces = "application/json")
    public ResponseEntity<Boolean> payOrder(
            @PathVariable(value = "orderId") long orderId,
            @PathVariable(value = "userId") long userId) {

        boolean orderEntity = orderService.payOrder(userId, orderId);
        if (orderEntity) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
