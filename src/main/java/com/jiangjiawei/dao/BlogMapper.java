package com.jiangjiawei.dao;

import com.jiangjiawei.domain.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BlogMapper {

    //查找所有博客
    List<Blog> findBlogAll();

    //根据条件查询符合条件的Blog
    List<Blog> findBlogByCondition(Map<String,Object> map);

    //根据多个ID查找Blog
    List<Blog> findBlogByIds(List<String> list);

    //添加Blog
    void insertBlog(Blog blog);

    //修改Blog信息
    void updateBlog(Map<String,Object> map);
}
