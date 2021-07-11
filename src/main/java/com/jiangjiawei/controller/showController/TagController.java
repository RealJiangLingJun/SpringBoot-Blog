package com.jiangjiawei.controller.showController;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangjiawei.domain.Blog;
import com.jiangjiawei.domain.Columnist;
import com.jiangjiawei.domain.Tag;
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
public class TagController {

    //一页显示的数据
    private static final int SIZE = 5;

    @Autowired
    private BlogService blogService;

    @Autowired
    private ColumnistService columnistService;

    @Autowired
    private TagService tagService;


    //前往标签页面
    @GetMapping("/tag")
    public String tag(Model model){

        //标签页面和专栏页面十分相似

        //查询出所有的 标签 信息，要在页面中展示
        //这里需要我们添加约束条件，查询得到的标签必须是正在使用中的
        Map<String,Object> mapTag = new HashMap<>();
        mapTag.put("tagState",1);
        List<Tag> tagList = tagService.getTagByCondition(mapTag);
        model.addAttribute("Tags",tagList);

        System.out.println(tagList);

        //第一次进到专栏页面，首先查询第一个专栏的博客信息，默认先展示第一个的
        //查询所有的专栏信息，这里要使用分页插件
        //这里返回变成了PageInfo 是为了方便以后的翻页
        Map<String,Object> map = new HashMap<>();
        map.put("tags",tagList.get(0).getId()+"");
        map.put("blogState",1);//添加约束条件
        System.out.println(map.toString());
        PageHelper.startPage(1,SIZE);
        List<Blog> blogList = blogService.getBlogByCondition(map);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        model.addAttribute("PageInfo",pageInfo);//要的

        //这里传递的是当前默认选中的专栏信息
        Tag defaultTag = tagList.get(0);
        model.addAttribute("defaultTag",defaultTag);

        return "tag";
    }


    //专栏的分页查询
    @GetMapping("/find_tag_paging")
    public String findTagPaging(@RequestParam Map<String,Object> map, Model model){

        //PageInfo分页管理的bean
        //查询得到一分也好的博客信息
        PageHelper.startPage(Convert.toInt(map.get("currentPage")),SIZE);
        map.put("blogState",1);//添加约束条件
        List<Blog> blogList = blogService.getBlogByCondition(map);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        model.addAttribute("PageInfo",pageInfo);//要的


        //查询到当前在显示的专栏信息，是因为要展示博客是要用到对应的专栏信息
        //最重要的是要在html里藏一个当前标签信息id
        List<String> list = new ArrayList<>();
        list.add(map.get("tags")+"");
        Tag defaultTag = tagService.getTagByIds(list).get(0);
        model.addAttribute("defaultTag",defaultTag);//要的

        //需要所有的标签信息，因为在展示时需要进行循环找到对应的标签
        //但是标签必须是在使用中，不能是删除的
        Map<String,Object> mapTag = new HashMap<>();
        mapTag.put("tagState",1);
        List<Tag> tagList = tagService.getTagByCondition(mapTag);
        model.addAttribute("Tags",tagList);


        return "tag::table_refresh";
    }


    //用户点击侧边栏的专栏信息，查询对应的博客
    @GetMapping("/check_tag")
    public String checkColumnist(String tags,Model model){

        //PageInfo分页管理的bean
        //查询得到博客信息，但这是首页展示，所以分页为 1
        PageHelper.startPage(1,SIZE);

        Map<String,Object> map = new HashMap<>();
        map.put("tags",tags);
        map.put("blogState",1);//添加约束条件
        List<Blog> blogList = blogService.getBlogByCondition(map);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        model.addAttribute("PageInfo",pageInfo);

        //查询到当前在显示的专栏信息，是因为要展示博客是要用到对应的专栏信息
        List<String> list = new ArrayList<>();
        list.add(tags);
        Tag defaultTag = tagService.getTagByIds(list).get(0);
        model.addAttribute("defaultTag",defaultTag);//要的


        //需要所有的标签信息，因为在展示时需要进行循环找到对应的标签
        //但是标签必须是在使用中，不能是删除的
        Map<String,Object> mapTag = new HashMap<>();
        mapTag.put("tagState",1);
        List<Tag> tagList = tagService.getTagByCondition(mapTag);
        model.addAttribute("Tags",tagList);

        return "tag::table_refresh";

    }


    //在index中点击相应的 标签连接 ，跳转至标签页，并选中对应的标签，展示相应的信息
    @GetMapping("/checkTheTag")
    public String checkTheTag(String tagId,Model model){

        //查询出所有的 标签 信息，要在页面中展示
        //这里需要我们添加约束条件，查询得到的标签必须是正在使用中的
        Map<String,Object> mapTag = new HashMap<>();
        mapTag.put("tagState",1);
        List<Tag> tagList = tagService.getTagByCondition(mapTag);
        model.addAttribute("Tags",tagList);

        //第一次进到专栏页面，首先查询第一个专栏的博客信息，默认先展示第一个的
        //查询所有的专栏信息，这里要使用分页插件
        //这里返回变成了PageInfo 是为了方便以后的翻页
        Map<String,Object> map = new HashMap<>();
        map.put("tags",tagId);//tagId使用点击传递进来的id
        map.put("blogState",1);//添加约束条件
        PageHelper.startPage(1,SIZE);
        List<Blog> blogList = blogService.getBlogByCondition(map);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        model.addAttribute("PageInfo",pageInfo);//要的

        //这里传递的是当前默认选中的专栏信息
        List<String> list = new ArrayList<>();
        list.add(tagId);
        Tag defaultTag = tagService.getTagByIds(list).get(0);
        model.addAttribute("defaultTag",defaultTag);

        return "tag";
    }

}
