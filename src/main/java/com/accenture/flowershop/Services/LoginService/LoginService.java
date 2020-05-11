package com.accenture.flowershop.Services.LoginService;

import com.accenture.flowershop.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    UserEntity login(String login, String password, HttpServletRequest request);
}
