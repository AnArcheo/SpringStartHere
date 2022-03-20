package com.springstart.springstartch11_1.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


//enable OpenFeign clients and where to search dependency for proxy contracts (interfacees)
@Configuration
@EnableFeignClients(basePackages = "com.springstart.springstartch11_1.proxy")
public class ProjectConfig {
}
