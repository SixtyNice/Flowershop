package com.accenture.flowershop.DAO;

import com.accenture.flowershop.entity.CartEntity;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartDAO extends JpaRepository<CartEntity, UserEntity> {

    @Modifying
    @Query(value = "DELETE FROM CART WHERE flower_name=?1 and user_id=?2", nativeQuery = true)
    void deleteFlowerFromCart(String flowerName, UUID userId);

    @Modifying
    @Query(value = "DELETE FROM CART WHERE user_id=?1", nativeQuery = true)
    void clearCart(UUID userId);

    List<CartEntity> findByUserId(UUID userId);
}
