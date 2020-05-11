package com.accenture.flowershop.Configuration;

import com.accenture.flowershop.SecurityServer.AdminFilter;
import com.accenture.flowershop.SecurityServer.LoginFilter;
import com.accenture.flowershop.SecurityServer.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class SecurityFilterConfig {

    @Bean
    public FilterRegistrationBean<UserFilter> homeFilter() {
        FilterRegistrationBean<UserFilter> UserFilterBean = new FilterRegistrationBean<>();
        UserFilterBean.setFilter(new UserFilter());
//        UserFilterBean.addUrlPatterns("/home/*");
        UserFilterBean.addUrlPatterns("/cart/*");
        return UserFilterBean;
    }

    @Bean
    public FilterRegistrationBean<AdminFilter> adminFilter() {
        FilterRegistrationBean<AdminFilter> adminFilterBean = new FilterRegistrationBean<>();
        adminFilterBean.setFilter(new AdminFilter());
        adminFilterBean.addUrlPatterns("/admin/*");
        return adminFilterBean;
    }


    public FilterRegistrationBean<LoginFilter> loginFilter() {
        FilterRegistrationBean<LoginFilter> loginFilterBean = new FilterRegistrationBean<>();
        loginFilterBean.setFilter(new LoginFilter());
        loginFilterBean.addUrlPatterns("/login/*");
        return loginFilterBean;
    }
}
