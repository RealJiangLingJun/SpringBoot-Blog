package com.jiangjiawei.controller.adminController;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangjiawei.domain.Tag;
import com.jiangjiawei.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminTagController {

    //一页显示的数据
    private static final int SIZE = 10;

    @Autowired
    private TagService tagService;


    //前往标签管理页面
    @GetMapping("/tags")
    public String tags(Model model){

        //设置默认分页，默认显示的记录
        PageHelper.startPage(1,SIZE);
        PageInfo<Tag> pageInfo = tagService.getTagPaging(null);
        model.addAttribute("PageInfo",pageInfo);

        model.addAttribute("navIndex",3);
        return "admin/tags";
    }

    //前往新增标签页面
    @GetMapping("/to_add_tag")
    public String toAddTag(){
        return "admin/tag_add";
    }


    //新增标签
    @PostMapping("/add_tag")
    public String addTag(Tag tag){

        //设置更新时间
        tag.setCreateTime(new Date());
        //设置标签状态
        tag.setTagState(1);
        tag.setBlogCount(0);

        int state = tagService.insertTag(tag);
        if(state != 1){
            System.out.println("标签添加失败");
        }
        return "redirect:/admin/tags";
    }


    //删除标签
    @DeleteMapping("/delete_tag")
    @ResponseBody
    public String deleteTag(String id){
        int state = tagService.deleteTag(id);
        if(state != 1){
            System.out.println("删除标签失败");
            return "failed";
        }
        return "success";
    }

    //编辑博客
    @GetMapping("/edit_tag/{id}")
    public String editTag(@PathVariable String id, Model model){
        List list = new ArrayList();
        list.add(id);
        model.addAttribute("tag",tagService.getTagByIds(list).get(0));
        return "admin/tag_edit";
    }

    //更新博客
    @PostMapping("/update_tag")
    public String updateTag(Tag tag){

        tag.setCreateTime(new Date());
        System.out.println(tag.toString());
        //编辑标签默认将标签恢复使用状态
        tag.setTagState(1);
        int state = tagService.updateTag(tag);

        return "redirect:/admin/tags";
    }


    //分页查询
    @GetMapping("paging_query_tag")
    public String pagingQueryTag(@RequestParam Map<String,Object> map, Model model){
        //PageInfo分页管理的bean
        PageHelper.startPage(Convert.toInt(map.get("currentPage")),SIZE);
        PageInfo<Tag> pageInfo = tagService.getTagPaging(map);

        model.addAttribute("PageInfo",pageInfo);

        return "admin/tags::table_refresh";
    }

}
