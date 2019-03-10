package com.baizhi.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class MyInterceptorConfig extends WebMvcConfigurerAdapter {
    @Bean
    LoginInterceptor locaInterceptor(){
        return  new LoginInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(locaInterceptor()).addPathPatterns("/**/**")
                .excludePathPatterns("/admin/login");
        super.addInterceptors(registry);
    }
}
