package com.accenture.flowershop.Services.RegistrationService;

import com.accenture.flowershop.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;

public interface RegistrationService {

    boolean createUser(UserEntity user, HttpServletRequest request);
    boolean checkExistLogin(long login);

}
