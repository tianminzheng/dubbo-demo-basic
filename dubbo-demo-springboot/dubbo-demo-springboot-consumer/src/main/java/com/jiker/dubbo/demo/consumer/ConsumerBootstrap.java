package com.jiker.dubbo.demo.consumer;

import org.apache.dubbo.config.annotation.DubboReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.jiker.dubbo.demo.UserService;

@EnableAutoConfiguration
public class ConsumerBootstrap {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @DubboReference
    private UserService userService;

    public static void main(String[] args) {

        SpringApplication.run(ConsumerBootstrap.class).close();
    }

    @Bean
    public ApplicationRunner runner() {

        return args -> logger.info(userService.getUserByUserName("*").toString());
    }
}
