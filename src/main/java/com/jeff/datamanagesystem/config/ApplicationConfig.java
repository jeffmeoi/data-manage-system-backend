package com.jeff.datamanagesystem.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
public class ApplicationConfig {

    @Bean
    public Logger logger(){
        return LoggerFactory.getLogger("日志信息");
    }
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.parse("20MB"));
        factory.setMaxRequestSize(DataSize.parse("50MB"));
        return factory.createMultipartConfig();
    }
}
