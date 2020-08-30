package com.jiangjiawei.service.impl;

import com.jiangjiawei.dao.TagMapper;
import com.jiangjiawei.domain.Tag;
import com.jiangjiawei.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    //获取所有的标签信息
    public List<Tag> getAllTag() {
        return tagMapper.findTagAll();
    }
}
