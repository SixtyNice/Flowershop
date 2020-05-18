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
    private LoginServiceImpl loginService;


    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Boolean> login(@RequestBody UserEntity user,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
        boolean userEntity = loginService.login(user.getId(), user.getPassword(), request);

        if (userEntity) {

            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

}