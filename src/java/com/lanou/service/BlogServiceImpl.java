package com.lanou.service;

import com.lanou.bean.Blog;
import com.lanou.mapper.BlogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
