package com.yao.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yaochengkai on 2016/4/3.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("")
    public ModelAndView hello(String name) {
        ModelAndView modelAndView = new ModelAndView();
        if(StringUtils.isBlank(name)) {
            modelAndView.addObject("name", "World");
        } else {
            modelAndView.addObject("name", name);
        }
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
