package aother.pojo;

import java.util.Date;

public class Blog {
    private Integer id;

    private String title;

    private String summary;

    private Date publishDate;

    private Integer columnId;

    private Integer views;

    private String tags;

    private String comments;

    private String blogImg;

    private Byte blogState;

    private Byte admireState;

    private Byte commentState;

    private Byte recommendState;

    private Byte reprintState;

    private Date createTime;

    private byte[] content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getBlogImg() {
        return blogImg;
    }

    public void setBlogImg(String blogImg) {
        this.blogImg = blogImg == null ? null : blogImg.trim();
    }

    public Byte getBlogState() {
        return blogState;
    }

    public void setBlogState(Byte blogState) {
        this.blogState = blogState;
    }

    public Byte getAdmireState() {
        return admireState;
    }

    public void setAdmireState(Byte admireState) {
        this.admireState = admireState;
    }

    public Byte getCommentState() {
        return commentState;
    }

    public void setCommentState(Byte commentState) {
        this.commentState = commentState;
    }

    public Byte getRecommendState() {
        return recommendState;
    }

    public void setRecommendState(Byte recommendState) {
        this.recommendState = recommendState;
    }

    public Byte getReprintState() {
        return reprintState;
    }

    public void setReprintState(Byte reprintState) {
        this.reprintState = reprintState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}