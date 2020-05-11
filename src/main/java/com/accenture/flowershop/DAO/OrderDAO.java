package com.accenture.flowershop.DAO;

import com.accenture.flowershop.entity.OrderEntity;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<OrderEntity, UserEntity> {

    @Query(value = "SELECT * FROM ORDERS WHERE ORDER_ID=?1", nativeQuery = true)
    List<OrderEntity> findByOrderId(long orderId);

    List<OrderEntity> findByUserLogin(String login);
}
