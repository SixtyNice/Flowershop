package com.accenture.flowershop.WebService;

import com.accenture.flowershop.Services.FlowerService.FlowerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FlowersStockWebServiceImpl implements FlowersStockWebService {

    @Autowired
    private FlowerServiceImpl flowerService;


    @Override
    @Transactional
    public void increaseFlowersStockSize(int count) {
        flowerService.increaseFlowersStockSize(count);
    }


}
