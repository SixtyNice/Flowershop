//package com.accenture.flowershop.Controller;
//
//import com.accenture.flowershop.Services.OrderService.OrderServiceImpl;
//import com.accenture.flowershop.entity.OrderEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("{login}/order")
//public class OrderController {
//
//    @Autowired
//    private OrderServiceImpl orderService;
//
//    @PostMapping(path = "/createOrder", produces = "application/json")
//    public ResponseEntity<OrderEntity> createOrder(@PathVariable(value = "login") String login) {
//        OrderEntity order = orderService.createOrder(login);
//        if (order != null) {
//            return new ResponseEntity<>(order, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
////    @GetMapping(path = "/list", produces = "application/json")
////    public List<OrderEntity> getUserOrders(@PathVariable(value = "login") String login) {
////        return orderService.getUserOrder(login);
////    }
//
//
////    @GetMapping(path = "/{orderId}", produces = "application/json", consumes = "application/json")
////    public List<OrderEntity> getOrder(@PathVariable(value = "orderId") Long orderId) {
////        return orderService.findOrder(orderId);
////    }
//
////    @PostMapping(path = "/payOrder/{orderId}", produces = "application/json")
////    public ResponseEntity<List<OrderEntity>> payOrder(
////            @PathVariable(value = "orderId") Long orderId,
////            @PathVariable(value = "login") String login) {
////
////        List<OrderEntity> orderEntity = orderService.payOrder(login, orderId);
////        if (orderEntity != null) {
////            return new ResponseEntity<>(orderEntity, HttpStatus.OK);
////        }
////        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
////    }
//
//}
