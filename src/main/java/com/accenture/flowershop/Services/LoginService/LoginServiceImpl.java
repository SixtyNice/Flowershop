package com.accenture.flowershop.Services.LoginService;

import com.accenture.flowershop.DAO.UserDAO;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserDAO userDAO;

    public UserEntity login(String login, String password) {
        UserEntity user = userDAO.findUserByLogin(login);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                user.setPassword(null);
                return user;
            }
        }
        return null;
    }
}
