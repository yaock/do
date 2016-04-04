package com.yao.controller;

import com.yao.domain.User;
import com.yao.page.vo.LoginCommond;
import com.yao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by yaochengkai on 2016/4/3.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Resource
    private UserService userService;
    @RequestMapping("/index")
    public String loginPage() {
        return "login";
    }
    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommond loginCommand) {
        ModelAndView modelAndView = new ModelAndView();
        logger.info("用户：{} 进行登录", loginCommand.getUserName());
        boolean isValidUser = userService.hashMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if(!isValidUser) {
            logger.info("用户：{} 登录失败", loginCommand.getUserName());
            modelAndView.setViewName("login");
            modelAndView.addObject("error", "用户名或密码错误");
        } else {
            logger.info("用户：{} 登录成功", loginCommand.getUserName());
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(request.getRemoteAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            modelAndView.setViewName("main");
        }
        return modelAndView;
    }
}
