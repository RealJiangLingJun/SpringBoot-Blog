package com.jiangjiawei.service;

import com.github.pagehelper.PageInfo;
import com.jiangjiawei.domain.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {

    Blog getBlogById(String id);

    int addBlog(Blog blog,String state);

    List<Blog> getAllBlog();

    PageInfo<Blog> getBlogPaging();

    List<Blog> getBlogByCondition(Map<String,Object> map);

    List<Blog> findBlogByConditionByPublishdate();

    int updateBlog(Blog blog,String state);

    int deleteBlog(String id);

    List<Blog> getNewBlog(int number);

    int addViews(String blogId,String ip);
}
