package com.jiangjiawei.service;

import com.jiangjiawei.domain.Blog;

import java.util.List;
import java.util.Map;

public interface ArchiveService {

    //生成一个 归档需要的 key=年 value=博客信息 的 Map
    Map<Integer, List<Blog>> getMapKeyIsYear(List<Blog> blogList);
}
