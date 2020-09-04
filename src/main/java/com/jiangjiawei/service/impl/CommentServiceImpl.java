package com.jiangjiawei.service.impl;

import com.github.pagehelper.PageInfo;
import com.jiangjiawei.dao.CommentMapper;
import com.jiangjiawei.domain.Comment;
import com.jiangjiawei.domain.Tag;
import com.jiangjiawei.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentMapper commentMapper;

    @Override
    public PageInfo<Comment> getCommentPaging(Map<String, Object> map) {
        if(map == null){
            //如果map为空就查询所有
            return new PageInfo<Comment>(commentMapper.findCommentAll());
        }else {
            return new PageInfo<Comment>(commentMapper.findCommentByCondition(map));
        }
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public int deleteComment(String id) {
        List list = new ArrayList();
        list.add(id);
        Comment comment = (Comment) commentMapper.findCommentByIds(list).get(0);

        comment.setReplyState("0");
        return commentMapper.updateComment(comment);
    }

    @Override
    public List<Comment> getCommentByCondition(Map<String, Object> map) {
        return commentMapper.findCommentByCondition(map);
    }

    @Override
    public List<Comment> getCommentByIds(List<String> list) {
        return commentMapper.findCommentByIds(list);
    }


}
