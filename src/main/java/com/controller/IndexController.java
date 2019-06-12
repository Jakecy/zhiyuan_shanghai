package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: chihaojie
 * @Date: 2019/6/6 12:58
 * @Version 1.0
 * @Note
 */
//@Controller
public class IndexController {


    @RequestMapping("/login")
    public String login(){
        System.out.println("==========================");
        return "login";
    }


}
