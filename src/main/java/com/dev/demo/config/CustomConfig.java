package com.dev.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String myExternalFilePath = "file:////home/ali/upload/";

        registry.addResourceHandler("/images/**").addResourceLocations(myExternalFilePath);

        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}