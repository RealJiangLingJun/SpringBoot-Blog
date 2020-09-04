package com.jiangjiawei.utils;

import com.jiangjiawei.domain.Columnist;
import com.jiangjiawei.domain.Tag;
import com.jiangjiawei.service.ColumnistService;
import com.jiangjiawei.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是一个博客更新工具
 * 在博客更新时可以调用它来帮助更新对应的标签，专栏中的数量
 */

@Component
public class BlogUpdateUtil {

    @Autowired
    private ColumnistService columnistService;

    @Autowired
    private TagService tagService;

    //更新专栏
    public void updateColumnist(String columnId,boolean operate){//operate 是要做的操作，true + ，false -
        if(!columnId.equals("")) {//判断博客的专栏信息不为空，否则就不会更新专栏信息
            List<String> list = new ArrayList<>();
            list.add(columnId);
            Columnist columnist = columnistService.findColumnistByIds(list).get(0);
            if (operate) {
                columnist.setBlogCount(columnist.getBlogCount() + 1);
            } else {
                if (columnist.getBlogCount() > 0) {
                    columnist.setBlogCount(columnist.getBlogCount() - 1);
                }
            }
            int state = columnistService.updateColumnist(columnist);
            if (state != 1) {
                System.out.println("没有成功修改专栏中的博客数据信息");
            }
        }
    }


    //更新标签
    public void updateTag(String tagId,boolean operate){//operate 是要做的操作，true + ，false -
        if(!tagId.equals("")) {//判断博客的标签信息不为空，否则就不会更新标签信息
            List<String> list = new ArrayList<>();
            list.add(tagId);
            Tag tag = tagService.getTagByIds(list).get(0);
            if (operate) {
                tag.setBlogCount(tag.getBlogCount() + 1);
            } else {
                if (tag.getBlogCount() > 0) {
                    tag.setBlogCount(tag.getBlogCount() - 1);
                }
            }
            int state = tagService.updateTag(tag);
            if (state != 1) {
                System.out.println("没有成功修改标签中的博客数据信息");
            }
        }
    }

}
