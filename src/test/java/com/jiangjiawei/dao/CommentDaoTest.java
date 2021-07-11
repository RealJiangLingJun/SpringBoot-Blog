//package com.jiangjiawei.dao;
//
//import com.jiangjiawei.domain.Comment;
//import com.jiangjiawei.service.CommentService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//
//@SpringBootTest
//public class CommentDaoTest {
//
//    @Autowired
//    private CommentService commentService;
//
//
//    @Test
//    public void insertComment(){
//        for(int i=0;i<100;i++){
//            Comment comment = new Comment(null,"jjw"+i,"fsfsafwefew",i,new Date(),
//                    "否","已通过","是否哈苏返回"+i,null,new Date());
//            commentService.insertComment(comment);
//        }
//    }
//}
