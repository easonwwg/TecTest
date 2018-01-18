package com.sac.controller;

import com.sac.autowaired.IAnimal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author:eason
 * @Description
 * @Date: 22:10,2018/1/16
 * @ModifiedBy
 */
@Controller
public class MyController {

    //通过xml配置bean
    @Resource(name = "dogComponent")
    private IAnimal dog;

    //通过代码配置bean
    @Resource(name = "catComponent")
    private IAnimal cat;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String index(){
        dog.say();
        cat.say();
        return "index";
    }

    @RequestMapping("login") //用来处理前台的login请求
    @ResponseBody
    private String login(
            @RequestParam(value = "username", required = false)String username,
            @RequestParam(value = "password", required = false)String password
    ){
        return "你好"+"Hello "+username+",Your password is: "+password;

    }
}
