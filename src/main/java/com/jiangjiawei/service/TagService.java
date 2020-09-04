package com.jiangjiawei.service;

import com.github.pagehelper.PageInfo;
import com.jiangjiawei.domain.Tag;

import java.util.List;
import java.util.Map;

public interface TagService {

    List<Tag> getAllTag();

    PageInfo<Tag> getTagPaging(Map<String,Object> map);

    int insertTag(Tag tag);

    int deleteTag(String id);

    List<Tag> getTagByIds(List<String> list);

    int updateTag(Tag tag);

    List<Tag> getTopTags(int number);

    List<Tag> getTagByCondition(Map<String,Object> map);
}
