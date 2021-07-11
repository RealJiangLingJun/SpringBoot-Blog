//package com.jiangjiawei.dao;
//
//import com.jiangjiawei.domain.Tag;
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
//public class TagDaoTest {
//
//    @Autowired
//    private TagMapper tagMapper;
//
//    @Test
//    public void test_findTagAll(){
//        System.out.println(tagMapper.findTagAll().size());
//    }
//
//    @Test
//    public void test_findTagByCondition(){
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","Java");
//        System.out.println(tagMapper.findTagByCondition(map).get(0).toString());
//    }
//
//    @Test
//    public void test_findTagByIds(){
//        ArrayList<String> list = new ArrayList<>();
//        list.add("1");
//        System.out.println(tagMapper.findTagByIds(list).get(0).toString());
//    }
//
//    @Test
//    public void test_insertTag(){
//        tagMapper.insertTag(new Tag(2,"Java",1024,1,new Date()));
//    }
//
//    @Test
//    public void test_updateTag(){
//        tagMapper.updateTag(new Tag(1,"科创板",100,1,new Date()));
//    }
//}
