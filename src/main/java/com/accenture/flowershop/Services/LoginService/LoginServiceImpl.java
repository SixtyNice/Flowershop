package com.accenture.flowershop.Services.LoginService;

import com.accenture.flowershop.DAO.UserDAO;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserEntity login(String login, String password, HttpServletRequest request) {
        UserEntity user = userDAO.findUserByLogin(login);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                HttpSession session = request.getSession(true);
                if (user.getLogin().equals("admin")) {
                    session.setAttribute("Admin", user);
                } else {
                    session.setAttribute("User", user);
                }
                user.setPassword(null);

                return user;
            }
        }
        return null;
    }

}