package com.accenture.flowershop.Controller;

import com.accenture.flowershop.Services.HomeService.HomeServiceImpl;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/home/")
public class HomeController {

    @Autowired
    HomeServiceImpl homeService;

    @GetMapping(path = "/{login}", produces = "application/json")
    public UserEntity getUser(@PathVariable(value = "login") String login,
                              HttpServletRequest request) {
        return homeService.getUser(login, request);
    }

}
