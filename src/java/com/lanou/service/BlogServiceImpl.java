package com.lanou.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Blog;
import com.lanou.mapper.BlogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/8/24.
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper mapper;
    @Override
    public Blog selectById(Blog blog) {
        Blog blog1 = mapper.selectById(blog);
        return blog1;
    }
    public List<Blog> findAllBlog() {
        return mapper.findBlog();
    }

    public void deleteId(Integer id) {
        mapper.delete(id);
    }
    //分页
    public PageInfo<Blog> querypage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum ==null ? 1: pageNum;
        pageSize = pageSize == null ? 5 :pageSize;

        PageHelper.startPage(pageNum,pageSize);
        List<Blog> list = mapper.findBlog();
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(list);

        return pageInfo;
    }

    public Blog insert(Blog blog) {
        mapper.insert(blog);
        return blog;
    }
}
