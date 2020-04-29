package com.accenture.flowershop.Services.LoginService;

import com.accenture.flowershop.entity.UserEntity;

public interface LoginService {
    UserEntity login(String login, String password);
}
