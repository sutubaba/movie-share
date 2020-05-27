package com.sutu.web.config;

import com.sutu.web.filter.LoginFilter;
import com.sutu.web.filter.StatusFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@Configuration
public class FilterConfig {

    @Bean
    public LoginFilter LoginFilter() {
        return new LoginFilter();
    }

    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilterFilterRegistrationBean() {

        FilterRegistrationBean<LoginFilter> loginFilterFilterRegistrationBean = new FilterRegistrationBean<>();

        loginFilterFilterRegistrationBean.addUrlPatterns("/auth/login");
        loginFilterFilterRegistrationBean.setOrder(-1);
        loginFilterFilterRegistrationBean.setFilter(LoginFilter());

        return loginFilterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<StatusFilter> statusFilterFilterRegistrationBean() {
        FilterRegistrationBean<StatusFilter> statusFilterFilterRegistrationBean = new FilterRegistrationBean<>();

        statusFilterFilterRegistrationBean.setFilter(new StatusFilter());
        statusFilterFilterRegistrationBean.addUrlPatterns("/*");
        statusFilterFilterRegistrationBean.setOrder(0);

        return statusFilterFilterRegistrationBean;
    }

}
