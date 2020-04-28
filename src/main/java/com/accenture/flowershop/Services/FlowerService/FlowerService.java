package com.accenture.flowershop.Services.FlowerService;

import com.accenture.flowershop.entity.FlowerEntity;

import java.util.List;

public interface FlowerService {
    List<FlowerEntity> getAllFlowers();

    FlowerEntity getFlowerByName(String name);

    List<FlowerEntity> getFlowersByPrice(int priceFrom, int priceTo);

}
