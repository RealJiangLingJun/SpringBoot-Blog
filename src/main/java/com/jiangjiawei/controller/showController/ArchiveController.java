package com.jiangjiawei.controller.showController;

import com.jiangjiawei.domain.Blog;
import com.jiangjiawei.service.ArchiveService;
import com.jiangjiawei.service.BlogService;
import com.jiangjiawei.service.ColumnistService;
import com.jiangjiawei.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 归档的controller
 */
@Controller
public class ArchiveController {


    //一页显示的数据
    private static final int SIZE = 10;

    @Autowired
    private BlogService blogService;

    @Autowired
    private ColumnistService columnistService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ArchiveService archiveService;


    //前往归档页
    @GetMapping("/archives")
    public String archives(Model model){

        //首先查出所有的博客,要添加约束条件（博客必须是已发布的博客）
        Map<String,Object> map = new HashMap<>();
        map.put("blogState",1);
        List<Blog> blogList = blogService.getBlogByCondition(map);
        model.addAttribute("Blogs",blogList);

        //博客总数
        int number = blogList.size();
        model.addAttribute("number",number);

        //获取一个以年为key的map
        Map<Integer,List<Blog>> years = archiveService.getMapKeyIsYear(blogList);
        model.addAttribute("years",years);

        return "archives";
    }
}
