package com.accenture.flowershop.Services.RegistrationService;

import com.accenture.flowershop.DAO.UserDAO;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    UserDAO userDAO;

    @Override
    public boolean createUser(UserEntity user) {
        if (checkExistLogin(user.getLogin())) {
            return false;
        }
        user.setBalance(new BigDecimal(2000));
        userDAO.save(user);
        return true;
    }

    @Override
    public boolean checkExistLogin(String login) {
        return userDAO.findUserByLogin(login) != null;
    }
}
