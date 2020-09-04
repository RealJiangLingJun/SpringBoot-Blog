package com.jiangjiawei.service;

import com.github.pagehelper.PageInfo;
import com.jiangjiawei.domain.Columnist;
import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.List;
import java.util.Map;

public interface ColumnistService {

    Map<String,String> getAllColumnistMap();

    List<Columnist> getAllColumnistList();

    PageInfo<Columnist> getColumnistPaging();

    int addColumnist(Columnist columnist);

    List<Columnist> getColumnistByCondition(Map<String,Object> map);

    int deleteColumnist(String id);

    int insertColumnist(Columnist columnist);

    List<Columnist> findColumnistByIds(List<String> list);

    int updateColumnist(Columnist columnist);

    int selectBlogCountById(int columnId);

    List<Columnist> getTopColumnist(int number);
}
