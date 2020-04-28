package com.accenture.flowershop.Services.CartService;

import com.accenture.flowershop.DAO.CartDAO;
import com.accenture.flowershop.DAO.FlowerDAO;
import com.accenture.flowershop.DAO.UserDAO;
import com.accenture.flowershop.entity.CartEntity;
import com.accenture.flowershop.entity.FlowerEntity;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private FlowerDAO flowerDAO;

    @Override
    @Transactional
    public String addToCart(String login, FlowerEntity flower) {
        UserEntity user = userDAO.findUserByLogin(login);
        FlowerEntity flowerFromDB = flowerDAO.findFlowerByName(flower.getName());
        CartEntity cart = new CartEntity(flower.getAmount(), flowerFromDB, user);

        int flowerCountDB = flowerFromDB.getAmount();
        int flowerCountFromReq = flower.getAmount();

        if (flowerCountFromReq <= flowerCountDB) {
            cartDAO.save(cart);
            return "Ok";
        }
        return "На складе нету столько цветов";
    }


    @Override
    @Transactional
    public void deleteFromCart(String login, FlowerEntity flower) {
        UserEntity user = userDAO.findUserByLogin(login);
        cartDAO.deleteFlowerFromCart(flower.getName(), user.getId());

    }

    @Override
    @Transactional
    public void clearCart(String login) {
        UserEntity user = userDAO.findUserByLogin(login);
        cartDAO.clearCart(user.getId());
    }

    @Override
    public List<CartEntity> getCart(String login) {
        UserEntity user = userDAO.findUserByLogin(login);
        List<CartEntity> cart = cartDAO.findByUserId(user.getId());
        for (CartEntity cartEntity : cart) {
            cartEntity.setUser(null);
        }
        return cart;
    }
}
