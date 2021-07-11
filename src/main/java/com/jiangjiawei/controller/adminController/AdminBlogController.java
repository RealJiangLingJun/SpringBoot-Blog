package com.jiangjiawei.controller.adminController;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 这个 控制层主要做 Blog的控制处理
 */
@Controller
@RequestMapping("/admin")
public class AdminBlogController {

    //一页显示的数据
    private static final int SIZE = 10;

    @Autowired
    private ColumnistService columnistService;

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    //前往管理员操作页面
    @GetMapping("/admin_navigation")
    public String adminNavigation(){
        return "admin/admin_navigation";
    }


    @GetMapping("/admin_index")
    public String admin_index(Model model){
        //在管理员界面展示需要 所有博客信息 分类信息
        //map<专栏id，专栏name>
        Map<String,String> columnistsMap = columnistService.getAllColumnistMap();
        System.out.println(columnistsMap.toString());
        model.addAttribute("ColumnistsMap",columnistsMap);
        //所有的专栏信息
        List<Columnist> columnistsList = columnistService.getAllColumnistList();
        model.addAttribute("ColumnistsList",columnistsList);
        //默认显示的记录
        PageHelper.startPage(1,SIZE);
        PageInfo<Blog> pageInfo = blogService.getBlogPaging();
        model.addAttribute("PageInfo",pageInfo);
        model.addAttribute("Blogs",pageInfo.getList());
        model.addAttribute("navIndex",1);
        return "admin/admin_index";
    }


    //前往增加博文页面
    @GetMapping("/to_add_blog")
    public String toAddBlog(Model model){
        //在添加博文之前，需要得到专栏信息，标签信息
        model.addAttribute("ColumnistsList",columnistService.getAllColumnistList());
        model.addAttribute("Tags",tagService.getAllTag());

        return "admin/add_blog";
    }

    //新增博文,并返回管理界面
    @PostMapping("/add_blog")
    public String addBlog(Blog blog,String state){
        if(ObjectUtil.isEmpty(blog)){
            //博文为空的情况，正常是要报错
            return "admin/admin_index";
        }
        System.out.println(blog.toString());
        //添加博文
        int statCode = blogService.addBlog(blog,state);
        if(statCode < 1){
            //添加博文失败，正常是要报错
            System.out.println("添加博文失败");
        }
        //添加成功，重定向到管理页面 让浏览器重新发请求
        return "redirect:/admin/admin_index";
    }


    //分页查询
    @GetMapping("/paging_query_blog")
    public String pagingQueryBlog(@RequestParam Map<String,Object> map, Model model){

        //PageInfo分页管理的bean
        PageHelper.startPage(Convert.toInt(map.get("currentPage")),SIZE);
        List<Blog> blogList = blogService.getBlogByCondition(map);
        PageInfo<Blog> pageInfo=new PageInfo(blogList);

        model.addAttribute("PageInfo",pageInfo);
        model.addAttribute("Blogs",pageInfo.getList());

        //map<专栏id，专栏name>
        Map<String,String> columnistsMap = columnistService.getAllColumnistMap();
        System.out.println(columnistsMap.toString());
        model.addAttribute("ColumnistsMap",columnistsMap);
        //所有的专栏信息
        List<Columnist> columnistsList = columnistService.getAllColumnistList();
        model.addAttribute("ColumnistsList",columnistsList);

        return "admin/admin_index::table_refresh";
    }


    //修改博客
    @GetMapping("/blog_edit/{id}")
    public String blogEdit(@PathVariable String id, Model model){
        Blog blog = null;
        //判断当前博客是否存在
        boolean flag = false;
        List<Blog> blogList = blogService.getAllBlog();
        if(!(ObjectUtil.isEmpty(id))) {//ID不为空
            for (Blog b : blogList) {
                if ((b.getId() + "").equals(id)) {
                    flag = true;
                    blog = b;
                    break;
                }
            }

        }
        if (flag) {//
            model.addAttribute("ColumnistsList",columnistService.getAllColumnistList());
            model.addAttribute("Tags",tagService.getAllTag());
            model.addAttribute("Blog",blog);
            return "admin/edit_blog";
        }
        System.out.println("找不到这个博客（ID="+id+"）了QAQ，去看看数据库吧！");
        model.addAttribute("tip","找不到这个博客了QAQ，去看看数据库吧！");
        return "redirect:/admin/admin_index";

    }


    //更新博客内容，并返回管理页面
    @PostMapping("/update_blog")
    public String upadteBlog(Blog blog, String state){
        if(ObjectUtil.isEmpty(blog)){
            //博文为空的情况，正常是要报错
            return "admin/admin_index";
        }

        //修改博文
        int statCode = blogService.updateBlog(blog,state);
        if(statCode < 1){
            //修改博文失败，正常是要报错
            System.out.println("修改博文失败QAQ，需要记录日志，");
        }
        //添加成功，重定向到管理页面 让浏览器重新发请求
        return "redirect:/admin/admin_index";
    }


    //删除博文，将博文状态标记为 -1
    @DeleteMapping("/delete_blog")
    @ResponseBody
    public String deleteBlog(String id){
        int state = blogService.deleteBlog(id);
        if(state != 1){
            return "failed";
        }
        return "success";
    }

}
