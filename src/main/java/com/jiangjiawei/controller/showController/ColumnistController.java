package com.jiangjiawei.controller.showController;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangjiawei.domain.Blog;
import com.jiangjiawei.domain.Columnist;
import com.jiangjiawei.service.BlogService;
import com.jiangjiawei.service.ColumnistService;
import com.jiangjiawei.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ColumnistController {


    //一页显示的数据
    private static final int SIZE = 5;

    @Autowired
    private BlogService blogService;

    @Autowired
    private ColumnistService columnistService;

    @Autowired
    private TagService tagService;


    //前往 专栏管理页面
    @GetMapping("/columnist")
    public String columnist(Model model){
        //要在专栏页面显示的信息

        //查询出所有的专栏信息，要在页面中展示
        //在查询前要添加限制条件，只查询使用中的专栏
        Map<String,Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("state",1);
        List<Columnist> columnistList = columnistService.getColumnistByCondition(stringObjectMap);
        model.addAttribute("Columnists",columnistList);

        //第一次进到专栏页面，首先查询第一个专栏的博客信息，默认先展示第一个的
        Map<String,Object> map = new HashMap<>();
        map.put("columnId",columnistList.get(0).getId());
        map.put("blogState",1);//查询博客添加限制条件
        //查询所有的专栏信息，这里要使用分页插件
        //这里返回变成了PageInfo 是为了方便以后的翻页
        PageHelper.startPage(1,SIZE);
        List<Blog> blogList = blogService.getBlogByCondition(map);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        model.addAttribute("PageInfo",pageInfo);

        //这里传递的是当前默认选中的专栏信息
        Columnist defaultColumnist = columnistList.get(0);
        model.addAttribute("defaultColumnist",defaultColumnist);

        return "columnist";
    }


    //专栏的分页查询
    @GetMapping("/find_columnist_paging")
    public String findColumnistPaging(@RequestParam Map<String,Object> map, Model model){

        //PageInfo分页管理的bean
        //查询得到一分也好的博客信息
        PageHelper.startPage(Convert.toInt(map.get("currentPage")),SIZE);
        map.put("blogState",1);//查询博客添加限制条件
        List<Blog> blogList = blogService.getBlogByCondition(map);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        model.addAttribute("PageInfo",pageInfo);

        //查询到当前在显示的专栏信息，是因为要展示博客是要用到对应的专栏信息
        List<String> list = new ArrayList<>();
        list.add(map.get("columnId")+"");
        Columnist columnistList = columnistService.findColumnistByIds(list).get(0);
        model.addAttribute("defaultColumnist",columnistList);


        return "columnist::table_refresh";
    }


    //用户点击侧边栏的专栏信息，查询对应的博客
    @GetMapping("/check_columnist")
    public String checkColumnist(String columnId,Model model){

        //PageInfo分页管理的bean
        //查询得到博客信息，但这是首页展示，所以分页为 1
        PageHelper.startPage(1,SIZE);

        Map<String,Object> map = new HashMap<>();
        map.put("columnId",columnId);
        map.put("blogState",1);//查询博客添加限制条件
        List<Blog> blogList = blogService.getBlogByCondition(map);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        model.addAttribute("PageInfo",pageInfo);

        //查询到当前在显示的专栏信息，是因为要展示博客是要用到对应的专栏信息
        List<String> list = new ArrayList<>();
        list.add(columnId);
        Columnist columnistList = columnistService.findColumnistByIds(list).get(0);
        model.addAttribute("defaultColumnist",columnistList);


        return "columnist::table_refresh";

    }


    //在index中点击相应的专栏标签 ，跳转至专栏页，并选中对应的专栏，展示相应的信息
    @GetMapping("/checkTheColumn")
    public String checkTheColumn(String columnId,Model model){

        //查询出所有的专栏信息，要在页面中展示
        //在查询前要添加限制条件，只查询使用中的专栏
        Map<String,Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("state",1);
        List<Columnist> columnistList = columnistService.getColumnistByCondition(stringObjectMap);
        model.addAttribute("Columnists",columnistList);

        //第一次进到专栏页面，首先查询第一个专栏的博客信息，默认先展示第一个的
        Map<String,Object> map = new HashMap<>();
        map.put("columnId",columnId);//设置默认显示的专栏为传进来的专栏id
        map.put("blogState",1);//查询博客添加限制条件
        //查询所有的专栏信息，这里要使用分页插件
        //这里返回变成了PageInfo 是为了方便以后的翻页
        PageHelper.startPage(1,SIZE);
        List<Blog> blogList = blogService.getBlogByCondition(map);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        model.addAttribute("PageInfo",pageInfo);

        //这里传递的是当前默认选中的专栏信息
        List<String> list = new ArrayList<>();
        list.add(columnId);
        Columnist defaultColumnist = columnistService.findColumnistByIds(list).get(0);
        model.addAttribute("defaultColumnist",defaultColumnist);

        return "columnist";
    }

}
