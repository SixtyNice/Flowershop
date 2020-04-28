package com.accenture.flowershop.Controller;

import com.accenture.flowershop.Services.HomeService.HomeServiceImpl;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    HomeServiceImpl homeService;

    @GetMapping(path = "/{login}", produces = "application/json")
    public UserEntity getUser(@PathVariable(value = "login") String login) {
        return homeService.getUser(login);
    }

}
