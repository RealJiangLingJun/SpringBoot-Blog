package com.jiangjiawei.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.jiangjiawei.domain.Blog;
import com.jiangjiawei.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArchiveServiceImpl implements ArchiveService {



//    生成一个 归档需要的 key=年 value=博客信息 的 Map
    @Override
    public java.util.Map<Integer, List<Blog>> getMapKeyIsYear(List<Blog> blogList) {
        Map<Integer, List<Blog>> years = new HashMap<>();

        for (Blog blog : blogList) {
            Date blogDate = blog.getCreateTime();
            // yyyy
            Integer year = DateUtil.year(blogDate);
            // list --> yyyy
            if (years.get(year) == null) {
                // 对应年份没有博客
                List<Blog> list = new ArrayList();
                list.add(blog);
                years.put(year, list);
            } else {
                List<Blog> list = years.get(year);
                list.add(blog);
            }
        }
        return years;
    }
}
