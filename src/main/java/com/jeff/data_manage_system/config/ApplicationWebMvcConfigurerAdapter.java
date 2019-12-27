package com.jeff.data_manage_system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApplicationWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Value("${file.path}")
    public String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/files/**").addResourceLocations(uploadPath);
    }
}
