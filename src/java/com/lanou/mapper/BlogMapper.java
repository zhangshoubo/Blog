package com.lanou.mapper;

import com.lanou.bean.Blog;
import org.springframework.stereotype.Repository;

/**
 * Created by dllo on 17/8/24.
 */
@Repository
public interface BlogMapper {
    Blog selectById(Blog blog);
}
