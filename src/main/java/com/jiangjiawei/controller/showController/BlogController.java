package com.jiangjiawei.controller.showController;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangjiawei.domain.Blog;
import com.jiangjiawei.domain.Columnist;
import com.jiangjiawei.domain.Comment;
import com.jiangjiawei.domain.Tag;
import com.jiangjiawei.service.BlogService;
import com.jiangjiawei.service.ColumnistService;
import com.jiangjiawei.service.CommentService;
import com.jiangjiawei.service.TagService;
import com.jiangjiawei.utils.IpUtil;
import com.jiangjiawei.utils.MarkdownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BlogController {

    //一页显示的数据
    private static final int SIZE = 7;

    @Autowired
    private BlogService blogService;

    @Autowired
    private ColumnistService columnistService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    //前往展示的首页
    @GetMapping("/index")
    public String index(Model model){

        //需要获得 博客信息，专栏信息前10个、标签信息前10个
        //获取前 n 个 专栏信息
//        System.out.println("调用 --》 columnistService.getTopColumnist(10);");
        List<Columnist> columnists = columnistService.getTopColumnist(10);
        model.addAttribute("Columnists",columnists);

        //获取所有可展示的专栏信息 ，专栏状态为使用中
        Map<String,Object> map = new HashMap<>();
        map.put("blogState",1);
        List<Columnist> columnistsAll = columnistService.getColumnistByCondition(map);
        model.addAttribute("ColumnistsAll",columnistsAll);

        //获取前 n 个标签信息
        List<Tag> tags = tagService.getTopTags(10);
        model.addAttribute("Tags",tags);

        //默认显示的记录
        Map<String,Object> map1 = new HashMap<>();
        map1.put("blogState",1);
        PageHelper.startPage(1,SIZE);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogService.getBlogByCondition(map1));
        model.addAttribute("PageInfo",pageInfo);

        //查寻最新记得个博客
        List<Blog> newBlogList = blogService.getNewBlog(5);
        model.addAttribute("NewBlogs",newBlogList);

        return "index";
    }


    @GetMapping("/")
    public String navigation(Model model){
        //设置导航标签
        model.addAttribute("navIndex",1);
        return "navigation";
    }




    //前端展示博客的分页查询
    @GetMapping("/find_blog_paging")
    public String findBlogPaging(@RequestParam Map<String,Object> map, Model model){

        String orderBy = "b.publish_date desc";//按照（数据库）排序字段 倒序 排序

        //PageInfo分页管理的bean
        PageHelper.startPage(Convert.toInt(map.get("currentPage")),SIZE);
//        PageHelper.orderBy("order by b.publish_date desc");
        map.put("blogState",1);//分页时添加限制条件
        List<Blog> blogList = blogService.getBlogByCondition(map);
//        List<Blog> blogList = blogService.findBlogByConditionByPublishdate(map);
        PageInfo<Blog> pageInfo=new PageInfo(blogList);

        model.addAttribute("PageInfo",pageInfo);

        //查询出所有的专栏信息，以便于找到博客对应的专栏
        //查询专栏信息时添加限制条件
        Map<String,Object> map1 = new HashMap<>();
        map1.put("blogState",1);
        List<Columnist> columnistsAll = columnistService.getColumnistByCondition(map1);
        model.addAttribute("ColumnistsAll",columnistsAll);

        return "index::table_refresh";
    }


    //查看博客
    @GetMapping("/blog_detail/{id}")
    public String blogDetail(@PathVariable String id, Model model, HttpServletRequest request){

//        System.out.println(id);
        String ip = IpUtil.getIpAddr(request);
        System.out.println("访客地址："+ ip);
        Blog blog = blogService.getBlogById(id);
        if(blog == null){
            System.out.println("找不到博客！这里因该报错！");

        }

        //这里访问到了博客文章，所以这里就要对博客的浏览量+1
        blog.setViews((blog.getViews() == null)?0:blog.getViews()+1);
        int state = blogService.addViews(blog.getId()+"",ip);
        if(state != 1){
            System.out.println("博客的浏览量更新失败，需要报错！");
        }

        //对博客内容进行格式转换
        blog.setContent(MarkdownUtil.markdownToHtmlExtens(blog.getContent()));

        model.addAttribute("blog",blog);


        //这里展示博客的详细信息，包括了博客的评论
        //查询出博客对应的所有评论
        Map<String,Object> map = new HashMap<>();
        map.put("replyState","1");
        map.put("blogId",blog.getId());
        List<Comment> commentList = commentService.getCommentByCondition(map);

        model.addAttribute("Comments",commentList);

        return "blog";
    }


}
