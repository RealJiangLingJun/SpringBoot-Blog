package com.jiangjiawei.service;


import com.github.pagehelper.PageInfo;
import com.jiangjiawei.domain.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {

    PageInfo<Comment> getCommentPaging(Map<String,Object> map);

    int insertComment(Comment comment);

    int deleteComment(String id);

    List<Comment> getCommentByCondition(Map<String,Object> map);

    List<Comment> getCommentByIds(List<String> list);
}
