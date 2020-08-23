package com.jiangjiawei.dao;

import com.jiangjiawei.domain.Columnist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ColumnistMapper {

    //查询所有的专栏
    List<Columnist> findColumnistAll();

    //根据条件参数查询数据列表 模糊查询（like）
    List<Columnist> findColumnistByCondition(Map<String,Object> map);

    //根据多个主键查询对应的栏目
    List<Columnist> findColumnistByIds(List<String> list);

    //插入栏目信息
    void insertColumnist(Columnist columnist);

    //修改栏目信息
    void updateColumnist(Map<String,Object> map);

}
