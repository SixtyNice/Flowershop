package com.accenture.flowershop.Services.HomeService;

import com.accenture.flowershop.DTO.UserDTO;
import com.accenture.flowershop.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;

public interface HomeService {

    UserDTO getUser(long userId, HttpServletRequest request);

}
