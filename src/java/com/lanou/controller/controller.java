package com.lanou.controller;

import com.lanou.bean.User;
import com.lanou.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 17/8/23.
 */
@Controller
public class controller {

    @Resource
    private UserService service;
    @RequestMapping(value = "/")
    public String frontPage(){
        return "Main";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "/user/login";
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "/user/register";
    }

    //注册
//    @RequestMapping(value = "/regist",method = RequestMethod.POST)
//    public String regist(User user){
//        System.out.println(user);
//        service.insertUser(user);
//        return "redirct:/user/login";
//    }


    //注册
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> reg(User user) throws Exception {
        System.out.println(user);
        boolean f=service.regUser(user);
        Map<String,String> map=new HashMap<String,String>();
        if(f)
            map.put("reg", "yes");
        else
            map.put("reg", "no");
        return map;
    }

    //登录
    @RequestMapping(value = "/loginUser")
    public String loginUser(User user){

        service.checkUser(user);
        return null;
    }

    //检查用户名是否重复
    @RequestMapping(value = "/checkUserName",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Boolean> checkUserName(@Param("name") String name)  {
        boolean f = service.checkUserName(name);
        System.out.println(f);
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        map.put("Msg",f);
        return map;
    }

    }
