package com.jiker.dubbo.demo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiker.dubbo.demo.UserService;

public class Application {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println("result: " + userService.getUserByUserName("*"));
    }
}
