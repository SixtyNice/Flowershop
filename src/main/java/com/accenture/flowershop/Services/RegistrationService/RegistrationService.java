package com.accenture.flowershop.Services.RegistrationService;

import com.accenture.flowershop.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;

public interface RegistrationService {

    UserEntity createUser(UserEntity user, HttpServletRequest request);
    boolean checkExistLogin(String login);

}
