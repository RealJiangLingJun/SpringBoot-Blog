package com.jiangjiawei.controller;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangjiawei.domain.Blog;
import com.jiangjiawei.domain.Columnist;
import com.jiangjiawei.service.BlogService;
import com.jiangjiawei.service.ColumnistService;
import com.jiangjiawei.service.TagService;
import com.jiangjiawei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 这个 controller 主要做 专栏的控制转发
 */
@Controller
@RequestMapping("/admin")
public class ColumnistController {

    //一页显示的数据
    private static final int SIZE = 8;

    @Autowired
    private UserService userService;

    @Autowired
    private ColumnistService columnistService;

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;


    //前往 专栏管理页面
    @GetMapping("/admin_columnist")
    public String admin_columnist(Model model){

        //查询所有的专栏信息，这里要使用分页插件
        PageHelper.startPage(1,SIZE);
        PageInfo<Columnist> pageInfo = columnistService.getColumnistPaging();
        //查询所有专栏下的博客数量
        for(Columnist columnist : pageInfo.getList()){
            int count = columnistService.selectBlogCountById(columnist.getId());
            columnist.setBlogCount(count);
        }

        model.addAttribute("PageInfo",pageInfo);

        //设置导航标签
        model.addAttribute("navIndex",2);
        return "/admin/columnist";
    }

    //分页查询
    @GetMapping("/paging_query_columnist")
    public String pagingQueryColumnist(@RequestParam Map<String,Object> map,Model model){

        //PageInfo分页管理的bean
        PageHelper.startPage(Convert.toInt(map.get("currentPage")),SIZE);
        List<Columnist> columnistList = columnistService.getColumnistByCondition(map);
        PageInfo<Columnist> pageInfo =new PageInfo(columnistList);
        //查询所有专栏下的博客数量
        for(Columnist columnist : pageInfo.getList()){
            int count = columnistService.selectBlogCountById(columnist.getId());
            columnist.setBlogCount(count);
            System.out.println(columnist);
        }

        model.addAttribute("PageInfo",pageInfo);

        return "admin/columnist::table_refresh";
    }


    //删除博客
    @DeleteMapping("/delete_columnist")
    @ResponseBody
    public String deleteColumnist(String id){
        int state = columnistService.deleteColumnist(id);
        if(state != 1){
            return "failed";
        }
        return "success";
    }

    //前往新增专栏
    @GetMapping("/to_add_columnist")
    public String toAddColumnist(){
        return "/admin/add_columnist";
    }


    //新增专栏
    @PostMapping("/add_columnist")
    public String addColumnist(Columnist columnist){

        System.out.println(columnist);
        columnist.setCreateTime(new Date());
        columnist.setUpdateTime(new Date());
        columnist.setState(1);
        columnist.setBlogCount(0);
        System.out.println(columnist);
        int state = columnistService.insertColumnist(columnist);
        if (state != 1){
            System.out.println("专栏添加失败，应该报错记录日志");
        }
        return "redirect:/admin/admin_columnist";
    }

    //前往专栏编辑页面
    @GetMapping("/edit_columnist/{id}")
    public String editColumnist(@PathVariable String id,Model model){
        //查询对应的专栏
        List<String> list = new ArrayList<>();
        list.add(id);
        Columnist columnist = columnistService.findColumnistByIds(list).get(0);

        model.addAttribute("columnist",columnist);

        return "/admin/edit_columnist";
    }


    //更新专栏
    @PostMapping("/update_columnist")
    public String updateColumnist(Columnist columnist){

        columnist.setUpdateTime(new Date());
        int state = columnistService.updateColumnist(columnist);
        if (state != 1){
            System.out.println("专栏更新失败，应该报错，记录日志！");
        }
        return "redirect:/admin/admin_columnist";
    }
}