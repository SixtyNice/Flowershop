package com.accenture.flowershop.Services.LoginService;

import com.accenture.flowershop.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    boolean login(long userId, String password, HttpServletRequest request);
}
