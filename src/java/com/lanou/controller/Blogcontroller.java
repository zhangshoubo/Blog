package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Blog;
import com.lanou.bean.User;
import com.lanou.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/8/24.
 */
@Controller
public class Blogcontroller {
    @Resource
    private BlogService service;


    @RequestMapping(value = "/jumpinfo")
    public String jumpinfo(){
        return "blog/bloginfo";
    }

    //根据id查询返回所有内容
    @RequestMapping(value = "/selectById")
    @ResponseBody
    public Blog selectById(Blog blog, HttpServletRequest request){

        Blog blog1 = service.selectById(blog);
        request.setAttribute("bloginfo",blog1);
        System.out.println(blog1);
        return blog1;

    }
    @RequestMapping(value = "/frontPage")
    public String frontPage(){
        List<Blog> allBlog = service.findAllBlog();
        System.out.println(allBlog);
        return "Main";
    }
    @RequestMapping(value = "/getall")
    @ResponseBody
    public List<Blog> getAll(){
        List<Blog> allBlog = service.findAllBlog();
        return allBlog;
    }
    @RequestMapping(value = "/delete")
    public void delete(@RequestParam("id")Integer id){
        service.deleteId(id);

    }
    //分页
    @RequestMapping(value = "/pagetest")
    @ResponseBody
    public PageInfo<Blog> pagetest(@RequestParam("pageNum")Integer pageNum,
                                   @RequestParam("pageSize")Integer pageSize){

        PageInfo<Blog> page = service.querypage(pageNum, pageSize);

        return page;
    }



    @RequestMapping(value = "/addBlog")
    public String addBlog(){
        return "blog/addBlog";
    }
    @RequestMapping(value = "/praddBlog")
    public String praddBlog(){
        return "redirect:frontPage";
    }
    @RequestMapping(value = "/addnew")
    @ResponseBody
    public Map<String,String> addNew(Blog blog,HttpServletRequest request){

        User userinfo = (User) request.getSession().getAttribute("userinfo");
        Integer id = userinfo.getId();
        blog.setUserId(id);
        service.insert(blog);
        Map<String,String> map =new HashMap<String, String>();
        map.put("title",blog.getTitle());
        map.put("des",blog.getDes());
        map.put("content",blog.getContent());
        System.out.println(map+"___________________");
        return map;
    }
}
