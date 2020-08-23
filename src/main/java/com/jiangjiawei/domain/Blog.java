package com.jiangjiawei.domain;

import lombok.AllArgsConstructor;

import java.util.Date;

/**
 * blog
 * 
 * @author jjw
 * @version 1.0.0 2020-08-22
 */

@AllArgsConstructor
public class Blog implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -1303771901900394777L;

    /* This code was generated by TableGo tools, mark 1 begin. */

    /** 博客ID */
    private Integer id;

    /** 博客标题 */
    private String title;

    /** 博客摘要 */
    private String summary;

    /** 博客内容 */
    private String content;

    /** 发布时间 */
    private Date publishDate;

    /** 专栏ID（分类） */
    private Integer columnId;

    /** 浏览数 */
    private Integer views;

    /** 标签 */
    private String tags;

    /** 评论 */
    private String comments;

    /** 博客首页图 */
    private String blogImg;

    /** 状态（已发布、草稿） */
    private Integer blogState;

    /** 是否开启赞赏 */
    private Integer admireState;

    /** 是否开启评论 */
    private Integer commentState;

    /** 是否开启推荐 */
    private Integer recommendState;

    /** 是否开启转载声明 */
    private Integer reprintState;

    /** 创建博客时间 */
    private Date createTime;

    /* This code was generated by TableGo tools, mark 1 end. */

    /* This code was generated by TableGo tools, mark 2 begin. */

    /**
     * 获取博客ID
     * 
     * @return 博客ID
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置博客ID
     * 
     * @param id
     *          博客ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取博客标题
     * 
     * @return 博客标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置博客标题
     * 
     * @param title
     *          博客标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取博客摘要
     * 
     * @return 博客摘要
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * 设置博客摘要
     * 
     * @param summary
     *          博客摘要
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 获取博客内容
     * 
     * @return 博客内容
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 设置博客内容
     *
     * @param content
     *          博客内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", columnId=" + columnId +
                ", views=" + views +
                ", tags='" + tags + '\'' +
                ", comments='" + comments + '\'' +
                ", blogImg='" + blogImg + '\'' +
                ", blogState=" + blogState +
                ", admireState=" + admireState +
                ", commentState=" + commentState +
                ", recommendState=" + recommendState +
                ", reprintState=" + reprintState +
                ", createTime=" + createTime +
                '}';
    }

    /**
     * 获取发布时间
     *
     * @return 发布时间
     */
    public Date getPublishDate() {
        return this.publishDate;
    }

    /**
     * 设置发布时间
     * 
     * @param publishDate
     *          发布时间
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 获取专栏ID（分类）
     * 
     * @return 专栏ID（分类）
     */
    public Integer getColumnId() {
        return this.columnId;
    }

    /**
     * 设置专栏ID（分类）
     * 
     * @param columnId
     *          专栏ID（分类）
     */
    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    /**
     * 获取浏览数
     * 
     * @return 浏览数
     */
    public Integer getViews() {
        return this.views;
    }

    /**
     * 设置浏览数
     * 
     * @param views
     *          浏览数
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * 获取标签
     * 
     * @return 标签
     */
    public String getTags() {
        return this.tags;
    }

    /**
     * 设置标签
     * 
     * @param tags
     *          标签
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 获取评论
     * 
     * @return 评论
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * 设置评论
     * 
     * @param comments
     *          评论
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 获取博客首页图
     * 
     * @return 博客首页图
     */
    public String getBlogImg() {
        return this.blogImg;
    }

    /**
     * 设置博客首页图
     * 
     * @param blogImg
     *          博客首页图
     */
    public void setBlogImg(String blogImg) {
        this.blogImg = blogImg;
    }

    /**
     * 获取状态（已发布、草稿）
     * 
     * @return 状态（已发布、草稿）
     */
    public Integer getBlogState() {
        return this.blogState;
    }

    /**
     * 设置状态（已发布、草稿）
     * 
     * @param blogState
     *          状态（已发布、草稿）
     */
    public void setBlogState(Integer blogState) {
        this.blogState = blogState;
    }

    /**
     * 获取是否开启赞赏
     * 
     * @return 是否开启赞赏
     */
    public Integer getAdmireState() {
        return this.admireState;
    }

    /**
     * 设置是否开启赞赏
     * 
     * @param admireState
     *          是否开启赞赏
     */
    public void setAdmireState(Integer admireState) {
        this.admireState = admireState;
    }

    /**
     * 获取是否开启评论
     * 
     * @return 是否开启评论
     */
    public Integer getCommentState() {
        return this.commentState;
    }

    /**
     * 设置是否开启评论
     * 
     * @param commentState
     *          是否开启评论
     */
    public void setCommentState(Integer commentState) {
        this.commentState = commentState;
    }

    /**
     * 获取是否开启推荐
     * 
     * @return 是否开启推荐
     */
    public Integer getRecommendState() {
        return this.recommendState;
    }

    /**
     * 设置是否开启推荐
     * 
     * @param recommendState
     *          是否开启推荐
     */
    public void setRecommendState(Integer recommendState) {
        this.recommendState = recommendState;
    }

    /**
     * 获取是否开启转载声明
     * 
     * @return 是否开启转载声明
     */
    public Integer getReprintState() {
        return this.reprintState;
    }

    /**
     * 设置是否开启转载声明
     * 
     * @param reprintState
     *          是否开启转载声明
     */
    public void setReprintState(Integer reprintState) {
        this.reprintState = reprintState;
    }

    /**
     * 获取创建博客时间
     * 
     * @return 创建博客时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置创建博客时间
     * 
     * @param createTime
     *          创建博客时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /* This code was generated by TableGo tools, mark 2 end. */
}