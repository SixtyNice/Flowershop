package com.accenture.flowershop.Services.HomeService;

import com.accenture.flowershop.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;

public interface HomeService {

    UserEntity getUser(String login, HttpServletRequest request);

}
