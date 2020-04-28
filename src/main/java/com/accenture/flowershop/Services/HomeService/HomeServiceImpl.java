package com.accenture.flowershop.Services.HomeService;

import com.accenture.flowershop.DAO.UserDAO;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    UserDAO userDAO;

    public UserEntity getUser(String login) {
        return userDAO.findUserByLogin(login);
    }
}
