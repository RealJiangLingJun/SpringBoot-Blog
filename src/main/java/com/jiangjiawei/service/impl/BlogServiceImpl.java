package com.jiangjiawei.service.impl;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangjiawei.dao.BlogMapper;
import com.jiangjiawei.dao.ColumnistMapper;
import com.jiangjiawei.domain.Blog;
import com.jiangjiawei.domain.Columnist;
import com.jiangjiawei.service.BlogService;
import com.jiangjiawei.utils.BlogUpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private ColumnistMapper columnistMapper;

    @Autowired
    private BlogUpdateUtil blogUpdateUtil;

    //根据给定的信息对专栏、标签进行博客数量修改
    private void updateColumnistsAndTagsInfo(Blog blog,boolean flag){
        Integer oldColumnId = blog.getColumnId();
        String[] oldTags = blog.getTags().split(",");
        blogUpdateUtil.updateColumnist(oldColumnId + "", flag);
        for (String tag : oldTags) {
            blogUpdateUtil.updateTag(tag, flag);
        }
    }

    @Override
    //添加博客
    //开启事务
    @Transactional
    public int addBlog(Blog blog,String state) {

        //设置更新时间
        blog.setCreateTime(new Date());
        //判断是否为发布请求 博客状态 -1 删除 0 草稿 1 发布
        if(Convert.toInt(state) == 0){//保存草稿
            blog.setBlogState(0);
            blog.setPublishDate(null);
        }else if(Convert.toInt(state) == 1){//发布
            blog.setBlogState(1);
            blog.setPublishDate(new Date());
            updateColumnistsAndTagsInfo(blog,true);
        }

        return blogMapper.insertBlog(blog);
    }


    @Override
    public Blog getBlogById(String id){
        //找不到博客就返回空
        if(!"".equals(id)) {
            List<String> list = new ArrayList<>();
            list.add(id);
            List<Blog> blogs = blogMapper.findBlogByIds(list);
            if(blogs == null || blogs.size() ==0){
                return null;
            }
            return blogs.get(0);
        }
        return null;
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
    public List<Blog> findBlogByConditionByPublishdate() {
        return blogMapper.findBlogByConditionByPublishdate();
    }

    @Override
    @Transactional//开启事务
    //更新博客
    public int updateBlog(Blog blog,String state) {
        //state 标记前端触发的状态
        // -1 取消删除  0 保存    1 发布    2 取消发布
        // 保存 不改变博客状态


        //先查出原博客的所有信息
        List<String> list = new ArrayList<>();
        list.add(blog.getId() + "");
        Blog oldBlog = blogMapper.findBlogByIds(list).get(0);
        //原博客状态信息
        int oldState = oldBlog.getBlogState();

        //得到修改后的对应的专栏，更改专栏对应的博客数量信息
//        Integer columnId = blog.getColumnId();
//        //得到对应的标签，更改标签对应的博客数量信息
//        String[] tags = blog.getTags().split(",");

        //设置新博客更新时间
        blog.setCreateTime(new Date());

        //对state进行判断，若state为空，默认为0
        if(state == null) {
            state = "0";
        }
        if (oldState == 1) {//原博客已发布
            //先对原博客专栏、标签减1
            updateColumnistsAndTagsInfo(oldBlog, false);
            if (Convert.toInt(state) == 2) {//取消发布
                blog.setBlogState(0);
                blog.setPublishDate(null);
            } else if (Convert.toInt(state) == 0) {//保存
                blog.setBlogState(1);
                updateColumnistsAndTagsInfo(blog, true);
            }
        } else if (oldState == -1) {//原博客已删除
            if (Convert.toInt(state) == -1) {//取消删除
                blog.setBlogState(0);
                blog.setPublishDate(null);
            } else if (Convert.toInt(state) == 0) {//保存
                blog.setBlogState(-1);
                blog.setPublishDate(null);
            }
        } else if (oldState == 0) {//原博客为草稿
            if (Convert.toInt(state) == 1) {//发布
                blog.setBlogState(1);
                blog.setPublishDate(new Date());
                updateColumnistsAndTagsInfo(blog, true);
            } else if (Convert.toInt(state) == 0) {//保存
                blog.setBlogState(0);
                blog.setPublishDate(null);
            }
        }
        System.out.println(blog.toString());
        return blogMapper.updateBlog(blog);
    }

    @Override
    //开启事务
    @Transactional
    public int deleteBlog(String id) {
        //先查到要删除的博客
        List<String> list = new ArrayList<>();
        list.add(id);
        Blog blog = blogMapper.findBlogByIds(list).get(0);
        //获取博客状态，下面进行判断再修改
        int blogState = blog.getBlogState();

        blog.setCreateTime(new Date());
        //判断博客当前状态
        if(blogState == -1){//博客已删除，所以不做操作
            blog.setBlogState(-1);
        }else if(blogState == 0){//博客当前为草稿状态，可以删除
            blog.setBlogState(-1);//但是也不做修改其他操作
        }else if(blogState == 1){//博客为发布状态，可以删除
            blog.setBlogState(-1);
            updateColumnistsAndTagsInfo(blog,false);
        }
        return blogMapper.updateBlog(blog);
    }

    @Override
    //查询最新的几个博客
    public List<Blog> getNewBlog(int number) {
        return blogMapper.getNewBlog(number);
    }

    @Override
    //这个方法用来增加博客的浏览量,并设置最后访问时间，访问者 IP
    public int addViews(String blogId,String ip) {
        List<String> list = new ArrayList<>();
        list.add(blogId);
        Blog blog = blogMapper.findBlogByIds(list).get(0);

        blog.setViews((blog.getViews() == null)?0:blog.getViews()+1);
        //设置最后访问时间
        blog.setComments(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"-"+ip);

        return blogMapper.updateBlog(blog);
    }


}
