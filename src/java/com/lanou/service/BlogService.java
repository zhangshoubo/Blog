package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Blog;

import java.util.List;

/**
 * Created by dllo on 17/8/24.
 */
public interface BlogService {
    Blog selectById(Blog blog);
    List<Blog> findAllBlog();

    void deleteId(Integer id);

    //分页
    PageInfo<Blog> querypage(Integer pageNum, Integer pageSize);

    Blog insert(Blog blog);
}
