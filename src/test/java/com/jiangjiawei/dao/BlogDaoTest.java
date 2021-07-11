//package com.jiangjiawei.dao;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.jiangjiawei.domain.Blog;
//import com.jiangjiawei.service.BlogService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@SpringBootTest
//public class BlogDaoTest {
//
//    @Autowired
//    private BlogMapper blogMapper;
//
//    @Autowired
//    private BlogService blogService;
//
//    @Test
//    public void test_findBlogAll(){
//        System.out.println(blogMapper.findBlogAll().size());
//    }
//
//    @Test
//    public void test_findBlogByCondition(){
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","Java");
//        System.out.println(blogMapper.findBlogByCondition(map).get(0).toString());
//    }
//
//    @Test
//    public void test_findBlogByIds(){
//        ArrayList<String> list = new ArrayList<>();
//        list.add("1");
//        System.out.println(blogMapper.findBlogByIds(list).get(0).toString());
//    }
//
//    @Test
//    public void test_insertBlog(){
////        blogMapper.insertBlog(
////        new Blog(1,"Java基础","这里写的是jave基础部分",
////                "正文部分，此处省略100字。。。",new Date(),null,
////                null,0,"2","评论部分",null,1,
////                1,1,1,1,new Date())
////        );
//    }
//
//    //添加多条数据
//    @Test
//    public void insertBlogs(){
//        for(int i=0;i<100;i++){
////            Blog blog = new Blog(null,"Java基础"+i,"这里写的是jave基础部分"+i,
////                    "正文部分"+i,null,2,null,
////                    null,"2","评论部分"+i,null,1,
////                    1,1,1,1,new Date());
////            blogMapper.insertBlog(blog);
//        }
//    }
//
//    @Test
//    public void test_updateBlog(){
////        blogMapper.updateBlog(new Blog());
//    }
//
//    @Test
//    public void testPaging(){
//        PageHelper.startPage(1,8);
//        PageInfo<Blog> pageInfo = blogService.getBlogPaging();
//
//        for(Blog blog : pageInfo.getList()){
//            System.out.println(blog.getTitle());
//        }
//    }
//}
