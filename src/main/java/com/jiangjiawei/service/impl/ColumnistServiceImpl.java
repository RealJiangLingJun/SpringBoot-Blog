package com.jiangjiawei.service.impl;

import com.github.pagehelper.PageInfo;
import com.jiangjiawei.dao.BlogMapper;
import com.jiangjiawei.dao.ColumnistMapper;
import com.jiangjiawei.domain.Columnist;
import com.jiangjiawei.service.ColumnistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ColumnistServiceImpl implements ColumnistService {

    @Autowired
    private ColumnistMapper columnistMapper;

    @Autowired
    private BlogMapper blogMapper;

    @Override
    //获取所有的专栏信息
    public List<Columnist> getAllColumnist() {
        return columnistMapper.findColumnistAll();
    }

    @Override
    //用于在专栏首页的分页查询
    public PageInfo<Columnist> getColumnistPaging() {
        List<Columnist> columnists = columnistMapper.findColumnistAll();
        PageInfo<Columnist> pageInfo = new PageInfo<>(columnists);
        return pageInfo;
    }

    @Override
    public int addColumnist(Columnist columnist) {
        return columnistMapper.insertColumnist(columnist);
    }

    @Override
    public List<Columnist> getColumnistByCondition(Map<String, Object> map) {
        return columnistMapper.findColumnistByCondition(map);
    }

    @Override
    public int deleteColumnist(String id) {
        List<String> list = new ArrayList<>();
        list.add(id);
        Columnist columnist = columnistMapper.findColumnistByIds(list).get(0);
        columnist.setUpdateTime(new Date());
        columnist.setState(-1);
        return columnistMapper.updateColumnist(columnist);
    }

    @Override
    public int insertColumnist(Columnist columnist) {
        return columnistMapper.insertColumnist(columnist);
    }

    @Override
    public List<Columnist> findColumnistByIds(List<String> list) {
        return columnistMapper.findColumnistByIds(list);
    }

    @Override
    public int updateColumnist(Columnist columnist) {
        return columnistMapper.updateColumnist(columnist);
    }

    @Override
    public int selectBlogCountById(int columnId) {
        return blogMapper.selectBlogCountById(columnId);
    }


}
