//package com.accenture.flowershop.Configuration;
//
//import com.accenture.flowershop.WebServices.FlowersStockWebServiceImpl;
//import org.springframework.context.annotation.Bean;
//
//import javax.xml.ws.Endpoint;
//
//@org.springframework.ws.server.endpoint.annotation.Endpoint
//public class ServiceConfiguration {
//
//    @Bean
//    public void publishSOAP() {
//        Endpoint.publish("http://localhost:8081/ws/flowersStock", new FlowersStockWebServiceImpl());
//        System.out.println("SOAP Service has been started");
//    }
//}
