package com.jiker.dubbo.demo.consumer;

import com.jiker.dubbo.demo.User;
import com.jiker.dubbo.demo.consumer.facade.UserServiceFacade;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        UserServiceFacade facade = context.getBean("userServiceFacade", UserServiceFacade.class);
        User user = facade.getUserByUserName("*");
        System.out.println("result :" + user.toString());
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.duyi.dubbo.demo.consumer.facade")
    @PropertySource("classpath:/spring/dubbo-consumer.properties")
    @ComponentScan(value = {"com.jiker.dubbo.demo.consumer.facade"})
    static class ConsumerConfiguration {

    }
}
