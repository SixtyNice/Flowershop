package com.accenture.flowershop.Model.LoginService;

import com.accenture.flowershop.DAO.UserDAO;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserDAO userDAO;

    public UserEntity validate(String login, String password) {
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
