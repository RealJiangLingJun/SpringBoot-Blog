package com.jiangjiawei.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangjiawei.domain.Columnist;
import com.jiangjiawei.service.ColumnistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    private ColumnistService columnistService;



    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/")
    public String navigation(Model model){
        //设置导航标签
        model.addAttribute("navIndex",1);
        return "/navigation";
    }

    //前往 专栏管理页面
    @GetMapping("/columnist")
    public String admin_columnist(Model model){

        //查询所有的专栏信息，这里要使用分页插件
        PageHelper.startPage(1,8);
        PageInfo<Columnist> pageInfo = columnistService.getColumnistPaging();
        //查询所有专栏下的博客数量
        for(Columnist columnist : pageInfo.getList()){
            int count = columnistService.selectBlogCountById(columnist.getId());
            columnist.setBlogCount(count);
        }

        model.addAttribute("PageInfo",pageInfo);

        //设置导航标签
        model.addAttribute("navIndex",2);
        return "/columnist";
    }
}
