package com.yao.service;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by yaochengkai on 2016/4/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-mvc.xml","classpath*:/spring.xml"})
public class TestUserService {
    @Resource
    private UserService userService;

    @Test
    public void hashMatchUser() {
        boolean b1 = userService.hashMatchUser("admin", "123456");
        boolean b2 = userService.hashMatchUser("admin", "1111");
        Assert.assertEquals(false, b1);
        Assert.assertEquals(true, b2);
    }
}
