package com.jiker.dubbo.demo.consumer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.utils.SimpleReferenceCache;

import com.jiker.dubbo.demo.User;
import com.jiker.dubbo.demo.UserService;

public class Application {
    public static void main(String[] args) {
        runWithBootstrap();
    }

    private static void runWithBootstrap() {
        ReferenceConfig<UserService> reference = new ReferenceConfig<>();
        reference.setInterface(UserService.class);
        reference.setGeneric("true");

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("dubbo-demo-api-consumer"))
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .reference(reference)
                .start();

        UserService userService = SimpleReferenceCache.getCache().get(reference);
        User user = userService.getUserByUserName("*");
        System.out.println(user.toString());
    }
}
