package com.accenture.flowershop.Model.RegistrationService;

import com.accenture.flowershop.entity.UserEntity;

public interface RegistrationService {

    boolean createUser(UserEntity user);
    boolean checkExistLogin(String login);

}
