package com.accenture.flowershop.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FlowerStockEndpoint {
    private static final String NAME_SPACE_URI = "http://www.flowershop.accenture.com/WebServices";


    private FlowersStockWebServiceImpl flowersStockWebService;

    @Autowired
    public FlowerStockEndpoint(FlowersStockWebServiceImpl flowersStockWebService) {
        this.flowersStockWebService = flowersStockWebService;
    }

    @PayloadRoot(namespace = NAME_SPACE_URI, localPart = "IncreseFlowersStockRequest")
    @ResponsePayload
    public void increaseFlowersStockSize(@RequestPayload IncreaseFlowersStockRequest count) {
        flowersStockWebService.increaseFlowersStockSize(count.getCount());
    }
}
