
package com.jiker.dubbo.demo.provider;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import com.jiker.dubbo.demo.UserService;

public class Application {
    public static void main(String[] args) throws Exception {
        startWithBootstrap();
    }

    private static void startWithBootstrap() {
        ServiceConfig<UserServiceImpl> service = new ServiceConfig<>();
        service.setInterface(UserService.class);
        service.setRef(new UserServiceImpl());

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("dubbo-demo-api-provider"))
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .service(service)
                .start()
                .await();
    }
}
