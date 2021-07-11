//package com.jiangjiawei.dao;
//
//import com.jiangjiawei.domain.Columnist;
//import com.jiangjiawei.service.ColumnistService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//
//@SpringBootTest
//public class ColumnistDaoTest {
//
//    @Autowired
//    private ColumnistService columnistService;
//
//    //自动添加专栏信息
//    @Test
//    public void insertColumnist(){
//        for(int i=0;i< 100;i++){
//            Columnist columnist = new Columnist(null,"java测试"+i,"Java测试专栏"+i,
//                    0,1,new Date(),new Date());
//            columnistService.addColumnist(columnist);
//        }
//
//    }
//
//}
