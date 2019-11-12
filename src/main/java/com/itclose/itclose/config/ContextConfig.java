package com.itclose.itclose.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.itclose.itclose.repository"})
public class ContextConfig {

}