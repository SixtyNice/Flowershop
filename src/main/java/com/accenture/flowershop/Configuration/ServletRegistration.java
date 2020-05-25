//package com.accenture.flowershop.Configuration;
//
//import com.accenture.flowershop.WebServices.FlowersStockWebServiceImpl;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ServletRegistration {
//    @Bean
//    public ServletRegistrationBean<FlowersStockWebServiceImpl> flowerStockServlet() {
//        ServletRegistrationBean<FlowersStockWebServiceImpl> bean =
//                new ServletRegistrationBean<>(new FlowersStockWebServiceImpl(),
//                        "/ws/flowersStock/*");
//        bean.setLoadOnStartup(2);
//        return bean;
//    }
//}
