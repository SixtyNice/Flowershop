//package com.accenture.flowershop.Configuration;
//
//import com.accenture.flowershop.WebServices.FlowersStockWebServiceImpl;
//import com.accenture.flowershop.WebServlets.FlowersStockServlet;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//public class WebAppInitialize implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext container) throws ServletException {
//        AnnotationConfigWebApplicationContext ctx
//                = new AnnotationConfigWebApplicationContext();
//        ctx.register(ServiceConfiguration.class);
//        container.addListener(new ContextLoaderListener(ctx));
//
//        ServletRegistration.Dynamic servlet = container.addServlet(
//                "flowersStockServlet", new FlowersStockWebServiceImpl());
//        servlet.addMapping("/ws/flowersStock");
//    }
//}
