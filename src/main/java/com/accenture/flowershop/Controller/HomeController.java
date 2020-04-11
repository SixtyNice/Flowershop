package com.accenture.flowershop.Controller;

import com.accenture.flowershop.Model.HomeService.HomeService;
import com.accenture.flowershop.Model.LoginService.LoginService;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping(path = "/{login}", produces = "application/json")
    public UserEntity getUser(@PathVariable(value = "login") String login) {
        return homeService.getUser(login);
    }

}
