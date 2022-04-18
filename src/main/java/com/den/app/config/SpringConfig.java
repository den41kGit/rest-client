package com.den.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;


@Configuration
@ComponentScan("com.den.app")
@PropertySource("classpath:file.properties")
public class SpringConfig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

