package com.jiangjiawei.controller.showController;

import com.jiangjiawei.domain.Blog;
import com.jiangjiawei.domain.Comment;
import com.jiangjiawei.service.BlogService;
import com.jiangjiawei.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 评论controller
 */
@Controller
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;


    //添加评论
    @PostMapping("/add_comment")
    public String addComment(Comment comment, HttpSession session, Model model){

        //已有属性： blogId parentId replyName replyEmail

        comment.setId(null);
        //发布日期
        comment.setPublishDate(new Date());
        //是否为管理员
        if(session.getAttribute("user") != null) {
            comment.setBloggerState("1");
        }else {
            comment.setBloggerState("0");
        }
        //是否已发布
        comment.setReplyState("1");
        //创建时间
        comment.setCreateTime(new Date());

        int state = commentService.insertComment(comment);

        if(state != 1){
            System.out.println("评论添加失败！需要报错！");
        }

        //添加完评论，然后刷新页面

        return "redirect:/blog_detail/"+comment.getBlogId();



//        //查询出当前添加的品论对应的博客，前端展示需要判断
//        Blog blog = blogService.getBlogById(comment.getBlogId()+"");
//        model.addAttribute("blog",blog);
//
//        //查询出博客对应的所有评论
//        Map<String,Object> map = new HashMap<>();
//        map.put("replyState","1");
//        map.put("blogId",comment.getBlogId());
//        List<Comment> commentList = commentService.getCommentByCondition(map);
//
//        System.out.println(commentList);
//
//        model.addAttribute("Comments",commentList);
//
//        return "blog::refresh_area";

    }

}
