package com.accenture.flowershop.Services.RegistrationService;

import com.accenture.flowershop.DAO.UserDAO;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    UserDAO userDAO;

    @Override
    public UserEntity createUser(UserEntity user, HttpServletRequest request) {
        if (checkExistLogin(user.getLogin())) {
            return null;
        }

        HttpSession session = request.getSession(true);
        user.setBalance(new BigDecimal(2000));
        session.setAttribute("User", user);
        userDAO.save(user);
        return user;
    }

    @Override
    public boolean checkExistLogin(String login) {
        return userDAO.findUserByLogin(login) != null;
    }
}
