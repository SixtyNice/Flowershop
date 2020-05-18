package com.accenture.flowershop.Services.CartService;

import com.accenture.flowershop.DAO.*;
import com.accenture.flowershop.DTO.CartDTO;
import com.accenture.flowershop.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private FlowerDAO flowerDAO;

    @Autowired
    private CartFlowerDAO cartFlowerDAO;

    @Autowired
    private JoinCartFlowersDAO joinCartFlowersDAO;


    @Override
    @Transactional
    public String addToCart(long userId, FlowerEntity flowerFromReq) {
        Optional<UserEntity> user = userDAO.findById(userId);
        if (user.isPresent()) {
            Optional<FlowerEntity> flowerFromDB = flowerDAO.findById(flowerFromReq.getId());
            if (flowerFromDB.isPresent()) {
                Optional<CartEntity> cart = cartDAO.findByUserId(user.get().getId());
                CartFlowerEntity cartFlower = new CartFlowerEntity(flowerFromDB.get(), flowerFromReq.getAmount());
                cartFlowerDAO.save(cartFlower);

                if (cart.isPresent()) {
                    Set<JoinCartFlowersEntity> joinCartFlowersEntityList = cart.get().getCartUserFlowers();
                    JoinCartFlowersEntity joinCartFlowersEntity = new JoinCartFlowersEntity(cart.get(), cartFlower);
                    joinCartFlowersDAO.save(joinCartFlowersEntity);
                    joinCartFlowersEntityList.add(joinCartFlowersEntity);
                    cart.get().setCartUserFlowers(joinCartFlowersEntityList);
                    cartDAO.save(cart.get());
                } else {
                    cart = Optional.of(new CartEntity(user.get()));
                    cartDAO.save(cart.get());
                    JoinCartFlowersEntity joinCartFlowersEntity = new JoinCartFlowersEntity(cart.get(), cartFlower);
                    joinCartFlowersDAO.save(joinCartFlowersEntity);
                }
                return "ok";
            }
            return "No such flower";
        }
        return "No such user";
    }


    @Override
    @Transactional
    public boolean deleteFromCart(long id) {
        Optional<CartFlowerEntity> cartFlowerEntity = cartFlowerDAO.findById(id);
        if (cartFlowerEntity.isPresent()) {
            joinCartFlowersDAO.deleteByCartFlowerId(cartFlowerEntity.get());
            return true;
        } else {
            System.out.println("No such flower");
            return false;
        }
    }

    @Override
    @Transactional
    public boolean clearCart(long id) {
        Optional<UserEntity> user = userDAO.findById(id);
        if (user.isPresent()) {
            try {
                cartDAO.deleteAllByUserId(id);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public CartDTO getCart(long userId) {

        Optional<UserEntity> user = userDAO.findById(userId);
        if (user.isPresent()) {
            Optional<CartEntity> cartEntity = cartDAO.findByUserId(userId);
            if (cartEntity.isPresent()) {
                return new CartDTO(cartEntity.get());
            } else {
                return new CartDTO(new CartEntity(user.get()));
            }
        }
        return null;

    }
}
