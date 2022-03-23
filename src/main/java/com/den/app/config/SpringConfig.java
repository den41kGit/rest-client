package com.den.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.den.app")
@PropertySource("classpath:file.properties")
public class SpringConfig {
}
