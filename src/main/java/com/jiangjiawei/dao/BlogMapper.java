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

    //根据条件查询符合条件的Blog,但是加上了排序
    List<Blog> findBlogByConditionByPublishdate();

    //根据多个ID查找Blog
    List<Blog> findBlogByIds(List<String> list);

    //添加Blog
    int insertBlog(Blog blog);

    //修改Blog信息
    int updateBlog(Blog blog);

    //根据所给的专栏 id 查出在该id下的所有博客数量
    int selectBlogCountById(int columnId);

    List<Blog> getNewBlog(int number);


}
