package com.accenture.flowershop.Controller;

import com.accenture.flowershop.DTO.CartDTO;
import com.accenture.flowershop.Services.CartService.CartServiceImpl;
import com.accenture.flowershop.entity.FlowerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("{userId}/cart")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<CartDTO> getCart(@PathVariable(value = "userId") long userId) {
        CartDTO cart = cartService.getCart(userId);
        if (cart == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
    }

    @PostMapping(path = "/addToCart", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> addToCart(@PathVariable(value = "userId") Long userId, @RequestBody FlowerEntity flower) {
        String response = cartService.addToCart(userId, flower);
        if (response.equalsIgnoreCase("ok")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if (response.equalsIgnoreCase("No such flower")) {
            return new ResponseEntity<>("No such flower", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("No such user", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/deleteFromCart", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Boolean> deleteFromCart(@RequestParam(name = "flowerId") long cartFlowerId) {
        boolean response = cartService.deleteFromCart(cartFlowerId);
        if (response) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/clearCart", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Boolean> clearCart(@RequestParam(name = "flowerId") long cartFlowerId) {
        boolean response = cartService.clearCart(cartFlowerId);
        if (response) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
