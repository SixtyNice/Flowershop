package com.accenture.flowershop.Controller;

import com.accenture.flowershop.Services.CartService.CartServiceImpl;
import com.accenture.flowershop.entity.CartEntity;
import com.accenture.flowershop.entity.FlowerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("{login}/cart")
public class CartController {

    @Autowired
    CartServiceImpl cartService;

    @GetMapping(produces = "application/json")
    public List<CartEntity> getCart(@PathVariable(value = "login") String login) {
        return cartService.getCart(login);
    }

    @PostMapping(path = "/addToCart", produces = "application/json", consumes = "application/json")
    public String addToCart(@PathVariable(value = "login") String login, @RequestBody FlowerEntity flower) {
        return cartService.addToCart(login, flower);
    }

    @PostMapping(path = "/deleteFromCart", produces = "application/json", consumes = "application/json")
    public void deleteFromCart(@PathVariable(value = "login") String login, @RequestBody FlowerEntity flower) {
        cartService.deleteFromCart(login, flower);

    }

    @PostMapping(path = "/clearCart", produces = "application/json", consumes = "application/json")
    public void clearCart(@PathVariable(value = "login") String login) {
        cartService.clearCart(login);
    }

}
