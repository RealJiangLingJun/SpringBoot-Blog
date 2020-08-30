package com.jiangjiawei.service;

import com.github.pagehelper.PageInfo;
import com.jiangjiawei.domain.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {

    int addBlog(Blog blog);

    List<Blog> getAllBlog();

    PageInfo<Blog> getBlogPaging();

    List<Blog> getBlogByCondition(Map<String,Object> map);

    int updateBlog(Blog blog);

    int deleteBlog(String id);
}
