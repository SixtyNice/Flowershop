package com.accenture.flowershop.Services.FlowerService;

import com.accenture.flowershop.entity.FlowerEntity;
import com.accenture.flowershop.entity.FlowerFilter;

import java.util.List;

public interface FlowerService {
    List<FlowerEntity> getAllFlowers();

    FlowerEntity getFlowerByName(FlowerFilter flowerFilter);

    List<FlowerEntity> getFlowersByPrice(FlowerFilter flowerFilter);

    void increaseFlowersStockSize(int count);

}
