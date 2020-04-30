package com.accenture.flowershop.Controller;

import com.accenture.flowershop.Services.LoginService.LoginServiceImpl;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public UserEntity login(@RequestBody UserEntity user) {
        return loginService.login(user.getLogin(), user.getPassword());
    }


}