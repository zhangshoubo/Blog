package com.lanou.controller;

import com.lanou.bean.User;
import com.lanou.service.UserService;
import org.apache.ibatis.annotations.Param;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 17/8/23.
 */
@Controller
public class Usercontroller {

    @Resource
    private UserService service;
    @RequestMapping(value = "/")
    public String frontPage(){
        return "user/login";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "user/login";
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "user/register";
    }

    @RequestMapping(value = "/jumpindex")
    public String jump(){
        return "Main";

    }
    @RequestMapping(value = "/jumplogin")
    public String jumpLogin(){
        return "user/login";
    }

    @RequestMapping(value = "/jumpregister")
    public String jumpregister(){
        return "user/register";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "user/login";
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
    public String  reg(User user) throws Exception {
        System.out.println(user);
        boolean f=service.regUser(user);
        Map<String,String> map=new HashMap<String,String>();
        System.out.println(f);
        if(f){
            map.put("Msg", "yes");
            return "yes";
        }
       return "no";
    }

    //登录
    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    @ResponseBody
    public String  loginUser(HttpServletRequest request, User user){
        System.out.println(user);
        User user1 = service.checkUser(user);
        request.getSession().setAttribute("userinfo",user1);
        if (user1.getName().isEmpty()&&user.getName().isEmpty()){
            return "no";
        }else {
            return "yes";
        }
    }


    //检查用户名是否重复
    @RequestMapping(value = "/checkUserName",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Boolean> checkUserName(@Param("name") String name)  {
        boolean f = service.checkUserName(name);
//        System.out.println(f);
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        map.put("Msg",f);
        return map;
    }




    }
