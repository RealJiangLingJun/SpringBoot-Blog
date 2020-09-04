package com.jiangjiawei.dao;

import com.jiangjiawei.domain.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TagMapper {

    //查询所有的 标签
    List<Tag> findTagAll();

    //根据条件参数查询 标签 模糊查询（like）
    List<Tag> findTagByCondition(Map<String,Object> map);

    //根据多个主键查询对应的标签
    List<Tag> findTagByIds(List<String> list);

    //增加标签信息
    int insertTag(Tag tag);

    //修改标签信息
    int updateTag(Tag tag);

    List<Tag> getTopTags(int number);
}
