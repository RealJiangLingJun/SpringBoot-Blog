package aother.pojo;

import java.util.Date;

public class Comment {
    private Integer id;

    private String replyName;

    private String replyEmail;

    private Integer blogId;

    private Date publishDate;

    private String bloggerState;

    private String replyState;

    private String replyContent;

    private Integer parentId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName == null ? null : replyName.trim();
    }

    public String getReplyEmail() {
        return replyEmail;
    }

    public void setReplyEmail(String replyEmail) {
        this.replyEmail = replyEmail == null ? null : replyEmail.trim();
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getBloggerState() {
        return bloggerState;
    }

    public void setBloggerState(String bloggerState) {
        this.bloggerState = bloggerState == null ? null : bloggerState.trim();
    }

    public String getReplyState() {
        return replyState;
    }

    public void setReplyState(String replyState) {
        this.replyState = replyState == null ? null : replyState.trim();
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}