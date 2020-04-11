package com.accenture.flowershop.Controller;

import com.accenture.flowershop.Model.LoginService.LoginService;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public UserEntity login(@RequestBody UserEntity user) {
        return loginService.validate(user.getLogin(), user.getPassword());
    }


}