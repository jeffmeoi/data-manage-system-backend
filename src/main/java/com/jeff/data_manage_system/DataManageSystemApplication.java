package com.jeff.data_manage_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DataManageSystemApplication extends WebMvcConfigurerAdapter {


    public static void main(String[] args) {
        SpringApplication.run(DataManageSystemApplication.class, args);
    }


}
