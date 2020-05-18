package com.accenture.flowershop.DAO;

import com.accenture.flowershop.entity.CartFlowerEntity;
import com.accenture.flowershop.entity.JoinCartFlowersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinCartFlowersDAO extends JpaRepository<JoinCartFlowersEntity, Long> {

    @Modifying
    void deleteByCartFlowerId(CartFlowerEntity cartFlowerEntity);

}
