package com.jiangjiawei.service.impl;

import com.github.pagehelper.PageInfo;
import com.jiangjiawei.dao.BlogMapper;
import com.jiangjiawei.dao.ColumnistMapper;
import com.jiangjiawei.domain.Columnist;
import com.jiangjiawei.service.ColumnistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ColumnistServiceImpl implements ColumnistService {

    @Autowired
    private ColumnistMapper columnistMapper;

    @Autowired
    private BlogMapper blogMapper;

    //将查询到的专栏信息从集合中转化到Map中
    private Map<String ,String> toMap(List<Columnist> list){
        Map<String ,String> map = new HashMap<>();
        for(Columnist columnist : list){
            map.put(columnist.getId()+"",columnist.getName());
        }
        return map;
    }

    @Override
    //获取所有的专栏信息
    public Map<String ,String> getAllColumnistMap() {
        List<Columnist> columnistList = columnistMapper.findColumnistAll();
        return toMap(columnistList);
    }

    @Override
    public List<Columnist> getAllColumnistList() {
        List<Columnist> columnistList = columnistMapper.findColumnistAll();
        return columnistList;
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

    @Override
    public List<Columnist> getTopColumnist(int number) {
        System.out.println("调用 --》columnistMapper.getTopColumnist(number);");
        return columnistMapper.getTopColumnist(number);
    }


}
