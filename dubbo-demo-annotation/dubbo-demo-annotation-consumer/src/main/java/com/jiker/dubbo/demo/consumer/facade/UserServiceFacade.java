
package com.jiker.dubbo.demo.consumer.facade;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

import com.jiker.dubbo.demo.User;
import com.jiker.dubbo.demo.UserService;

@Component("userServiceFacade")
public class UserServiceFacade {

    @DubboReference
    private UserService userService;

    public User getUserByUserName(String name) {

        return userService.getUserByUserName(name);
    }
}
