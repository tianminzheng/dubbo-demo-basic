
package com.jiker.dubbo.demo.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jiker.dubbo.demo.User;
import com.jiker.dubbo.demo.UserService;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUserByUserName(String userName) {
        logger.info("getUserByUserName: " + userName);

        return new User(1L, "jiker", "123456");
    }
}
