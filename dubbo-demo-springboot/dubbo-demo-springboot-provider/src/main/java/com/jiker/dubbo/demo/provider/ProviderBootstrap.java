
package com.jiker.dubbo.demo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class ProviderBootstrap {

    public static void main(String[] args) {

        SpringApplication.run(ProviderBootstrap.class, args);
    }
}
