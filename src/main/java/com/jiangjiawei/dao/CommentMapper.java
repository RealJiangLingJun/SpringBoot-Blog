package com.jiangjiawei.dao;

import com.jiangjiawei.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentMapper {

    //查询所有的评论信息
    List<Comment> findCommentAll();

    //根据条件参数查询相关的评论 模糊查询（like）
    List<Comment> findCommentByCondition(Map<String,Object> map);

    //根据多个主键查询对应的评论
    List<Comment> findCommentByIds(List<String> list);

    //增加评论信息
    int insertComment(Comment comment);

    //修改评论信息
    int updateComment(Comment comment);
}
