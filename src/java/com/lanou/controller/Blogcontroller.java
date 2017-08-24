package com.lanou.controller;

import com.lanou.bean.Blog;
import com.lanou.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/8/24.
 */
@Controller
public class Blogcontroller {
    @Resource
    private BlogService service;

    //根据id查询返回所有内容
    @RequestMapping(value = "/selectById")
    @ResponseBody
    public Blog selectById(Blog blog){
        Blog blog1 = service.selectById(blog);
        return blog1;

    }
}
