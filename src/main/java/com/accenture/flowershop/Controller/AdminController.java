package com.accenture.flowershop.Controller;

import com.accenture.flowershop.Services.AdminService.AdminServiceImpl;
import com.accenture.flowershop.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping(produces = "application/json")
    public List<OrderEntity> loadOrders() {
        return adminService.loadOrders();
    }

    @PutMapping(path = "/closeOrder/{orderId}")
    public ResponseEntity<List<OrderEntity>> closeOrder(@PathVariable(value = "orderId") long orderId) {
        List<OrderEntity> orderEntityList = adminService.closeOrder(orderId);
        return new ResponseEntity<>(orderEntityList, HttpStatus.OK);

    }
}
