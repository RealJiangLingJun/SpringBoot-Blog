package com.jiangjiawei.domain;

import lombok.AllArgsConstructor;

import java.util.Date;

/**
 * tag
 * 
 * @author jjw
 * @version 1.0.0 2020-08-22
 */
@AllArgsConstructor
public class Tag implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 2553750883593612578L;

    /* This code was generated by TableGo tools, mark 1 begin. */

    /** 标签ID */
    private Integer id;

    /** 标签名称 */
    private String name;

    /** 博客数量 */
    private Integer blogCount;

    /** 创建时间 */
    private Date createTime;

    /* This code was generated by TableGo tools, mark 1 end. */

    /* This code was generated by TableGo tools, mark 2 begin. */

    /**
     * 获取标签ID
     * 
     * @return 标签ID
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置标签ID
     * 
     * @param id
     *          标签ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取标签名称
     * 
     * @return 标签名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置标签名称
     * 
     * @param name
     *          标签名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取博客数量
     * 
     * @return 博客数量
     */
    public Integer getBlogCount() {
        return this.blogCount;
    }

    /**
     * 设置博客数量
     * 
     * @param blogCount
     *          博客数量
     */
    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    /**
     * 获取创建时间
     * 
     * @return 创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置创建时间
     * 
     * @param createTime
     *          创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogCount=" + blogCount +
                ", createTime=" + createTime +
                '}';
    }

    /* This code was generated by TableGo tools, mark 2 end. */
}