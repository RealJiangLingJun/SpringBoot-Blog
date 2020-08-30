package com.jiangjiawei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangjiawei.dao.BlogMapper;
import com.jiangjiawei.domain.Blog;
import com.jiangjiawei.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    //添加博客
    public int addBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogMapper.findBlogAll();
    }

    @Override
    //首页的分页查询 直接将PageInfo返回方便前端处理
    public PageInfo<Blog> getBlogPaging() {
        List<Blog> blogList = blogMapper.findBlogAll();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }

    @Override
    public List<Blog> getBlogByCondition(Map<String, Object> map) {
        return blogMapper.findBlogByCondition(map);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public int deleteBlog(String id) {
        List<String> list = new ArrayList<>();
        list.add(id);
        Blog blog = blogMapper.findBlogByIds(list).get(0);
        blog.setBlogState(-1);
        return blogMapper.updateBlog(blog);
    }

}
