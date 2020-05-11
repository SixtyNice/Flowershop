package com.accenture.flowershop.Controller;

import com.accenture.flowershop.Services.LoginService.LoginServiceImpl;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;


    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<UserEntity> login(@RequestBody UserEntity user,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
        UserEntity userEntity = loginService.login(user.getLogin(), user.getPassword(), request);

        if (userEntity != null) {

            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }


}