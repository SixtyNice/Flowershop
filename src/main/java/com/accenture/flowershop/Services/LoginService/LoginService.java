package com.accenture.flowershop.Services.LoginService;

import com.accenture.flowershop.entity.UserEntity;

public interface LoginService {
    UserEntity validate(String login, String password);
}
