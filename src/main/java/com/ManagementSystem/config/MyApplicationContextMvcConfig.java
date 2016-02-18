package com.ManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/18 0018.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ManagementSystem.controller")
public class MyApplicationContextMvcConfig {
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {

        System.out.println("=================== init MyApplicationContextMvcConfig =======================");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
