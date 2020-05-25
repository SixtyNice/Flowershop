//package com.accenture.flowershop.Configuration;
//
//import com.accenture.flowershop.WebServices.FlowersStockWebService;
//import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ClientConfiguration {
//
//    @Bean
//    public Object generateProxy() {
//        return proxyFactoryBean().create();
//    }
//
//    @Bean
//    public JaxWsProxyFactoryBean proxyFactoryBean() {
//        JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
//        proxyFactory.setServiceClass(FlowersStockWebService.class);
//        proxyFactory.setAddress("http://localhost:8080/ws/flowersStock");
//        return proxyFactory;
//    }
//
//}