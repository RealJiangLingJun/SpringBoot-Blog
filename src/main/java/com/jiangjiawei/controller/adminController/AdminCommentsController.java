package com.jiangjiawei.controller.adminController;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangjiawei.domain.Comment;
import com.jiangjiawei.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminCommentsController {

    //一页显示的数据
    private static final int SIZE = 8;

    @Autowired
    private CommentService commentService;

    //前往评论管理页面
    @GetMapping("/comments")
    public String comments(Model model){

        //设置默认分页，默认显示的记录
        PageHelper.startPage(1,SIZE);
        PageInfo<Comment> pageInfo = commentService.getCommentPaging(null);

        model.addAttribute("PageInfo",pageInfo);
        model.addAttribute("navIndex",4);
        return "admin/comments";
    }

    //删除评论
    @DeleteMapping("/delete_comment")
    @ResponseBody
    public String deleteComment(String id){
        int state = commentService.deleteComment(id);
        if(state != 1){
            System.out.println("删除标签失败");
            return "failed";
        }
        return "success";
    }

    //分页查询
    @GetMapping("/paging_query_comment")
    public String pagingQueryComment(@RequestParam Map<String,Object> map, Model model){

        System.out.println(map.toString());

        //PageInfo分页管理的bean
        PageHelper.startPage(Convert.toInt(map.get("currentPage")),SIZE);
        PageInfo<Comment> pageInfo = commentService.getCommentPaging(map);

        model.addAttribute("PageInfo",pageInfo);

        return "admin/comments::table_refresh";
    }


    //查看评论详细信息
    @GetMapping("/comment_detail/{commentId}")
    public String commentDetail(@PathVariable String commentId,Model model){

        //查询出给定 id 对应的评论的详细信息
        List<String> list = new ArrayList<>();
        list.add(commentId);
        Comment comment = commentService.getCommentByIds(list).get(0);

        model.addAttribute("comment",comment);

        return "admin/comment_detail";
    }
}
