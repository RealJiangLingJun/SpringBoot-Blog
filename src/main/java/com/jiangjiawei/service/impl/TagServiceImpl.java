package com.jiangjiawei.service.impl;

import com.github.pagehelper.PageInfo;
import com.jiangjiawei.dao.TagMapper;
import com.jiangjiawei.domain.Tag;
import com.jiangjiawei.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    //获取所有的标签信息
    public List<Tag> getAllTag() {
        return tagMapper.findTagAll();
    }

    @Override
    public PageInfo<Tag> getTagPaging(Map<String,Object> map) {
        if(map == null){
            //如果map为空就查询所有
            return new PageInfo<Tag>(getAllTag());
        }else {
            return new PageInfo<Tag>(tagMapper.findTagByCondition(map));
        }
    }

    @Override
    public int insertTag(Tag tag) {
        return tagMapper.insertTag(tag);
    }

    @Override
    public int deleteTag(String id) {
        //根据提供的ID找到对应的标签
        List<String> list = new ArrayList<>();
        list.add(id);
        Tag tag = tagMapper.findTagByIds(list).get(0);

        tag.setTagState(-1);
        return tagMapper.updateTag(tag);
    }

    @Override
    public List<Tag> getTagByIds(List<String> list) {
        return tagMapper.findTagByIds(list);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public List<Tag> getTopTags(int number) {
        return tagMapper.getTopTags(number);
    }

    @Override
    public List<Tag> getTagByCondition(Map<String, Object> map) {
        return tagMapper.findTagByCondition(map);
    }
}
