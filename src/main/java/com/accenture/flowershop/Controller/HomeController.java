package com.accenture.flowershop.Controller;

import com.accenture.flowershop.DTO.UserDTO;
import com.accenture.flowershop.Services.HomeService.HomeServiceImpl;
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
    private HomeServiceImpl homeService;

    @GetMapping(path = "/{userId}", produces = "application/json")
    public UserDTO getUser(@PathVariable(value = "userId") long userId,
                           HttpServletRequest request) {
        return homeService.getUser(userId, request);
    }

}
