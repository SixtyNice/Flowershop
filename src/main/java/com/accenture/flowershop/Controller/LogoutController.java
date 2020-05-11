package com.accenture.flowershop.Controller;

import com.accenture.flowershop.Services.LogoutService.LogoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/logout")
public class LogoutController {

    @Autowired
    private LogoutServiceImpl logoutService;

    @PostMapping
    public void logout(HttpServletRequest request) {
        logoutService.logout(request);
    }
}
