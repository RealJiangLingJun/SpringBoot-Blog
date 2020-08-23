package aother.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("publish_date is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("publish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(Date value) {
            addCriterion("publish_date =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(Date value) {
            addCriterion("publish_date <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(Date value) {
            addCriterion("publish_date >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_date >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(Date value) {
            addCriterion("publish_date <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(Date value) {
            addCriterion("publish_date <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<Date> values) {
            addCriterion("publish_date in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<Date> values) {
            addCriterion("publish_date not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(Date value1, Date value2) {
            addCriterion("publish_date between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(Date value1, Date value2) {
            addCriterion("publish_date not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andColumnIdIsNull() {
            addCriterion("column_id is null");
            return (Criteria) this;
        }

        public Criteria andColumnIdIsNotNull() {
            addCriterion("column_id is not null");
            return (Criteria) this;
        }

        public Criteria andColumnIdEqualTo(Integer value) {
            addCriterion("column_id =", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdNotEqualTo(Integer value) {
            addCriterion("column_id <>", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdGreaterThan(Integer value) {
            addCriterion("column_id >", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("column_id >=", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdLessThan(Integer value) {
            addCriterion("column_id <", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdLessThanOrEqualTo(Integer value) {
            addCriterion("column_id <=", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdIn(List<Integer> values) {
            addCriterion("column_id in", values, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdNotIn(List<Integer> values) {
            addCriterion("column_id not in", values, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdBetween(Integer value1, Integer value2) {
            addCriterion("column_id between", value1, value2, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdNotBetween(Integer value1, Integer value2) {
            addCriterion("column_id not between", value1, value2, "columnId");
            return (Criteria) this;
        }

        public Criteria andViewsIsNull() {
            addCriterion("views is null");
            return (Criteria) this;
        }

        public Criteria andViewsIsNotNull() {
            addCriterion("views is not null");
            return (Criteria) this;
        }

        public Criteria andViewsEqualTo(Integer value) {
            addCriterion("views =", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotEqualTo(Integer value) {
            addCriterion("views <>", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsGreaterThan(Integer value) {
            addCriterion("views >", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("views >=", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsLessThan(Integer value) {
            addCriterion("views <", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsLessThanOrEqualTo(Integer value) {
            addCriterion("views <=", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsIn(List<Integer> values) {
            addCriterion("views in", values, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotIn(List<Integer> values) {
            addCriterion("views not in", values, "views");
            return (Criteria) this;
        }

        public Criteria andViewsBetween(Integer value1, Integer value2) {
            addCriterion("views between", value1, value2, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotBetween(Integer value1, Integer value2) {
            addCriterion("views not between", value1, value2, "views");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("tags is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("tags is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("tags =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("tags <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("tags >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("tags >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("tags <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("tags <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("tags like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("tags not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("tags in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("tags not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("tags between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("tags not between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("comments is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("comments is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("comments =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("comments <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("comments >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("comments >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("comments <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("comments <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("comments like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("comments not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("comments in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("comments not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("comments between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("comments not between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andBlogImgIsNull() {
            addCriterion("blog_img is null");
            return (Criteria) this;
        }

        public Criteria andBlogImgIsNotNull() {
            addCriterion("blog_img is not null");
            return (Criteria) this;
        }

        public Criteria andBlogImgEqualTo(String value) {
            addCriterion("blog_img =", value, "blogImg");
            return (Criteria) this;
        }

        public Criteria andBlogImgNotEqualTo(String value) {
            addCriterion("blog_img <>", value, "blogImg");
            return (Criteria) this;
        }

        public Criteria andBlogImgGreaterThan(String value) {
            addCriterion("blog_img >", value, "blogImg");
            return (Criteria) this;
        }

        public Criteria andBlogImgGreaterThanOrEqualTo(String value) {
            addCriterion("blog_img >=", value, "blogImg");
            return (Criteria) this;
        }

        public Criteria andBlogImgLessThan(String value) {
            addCriterion("blog_img <", value, "blogImg");
            return (Criteria) this;
        }

        public Criteria andBlogImgLessThanOrEqualTo(String value) {
            addCriterion("blog_img <=", value, "blogImg");
            return (Criteria) this;
        }

        public Criteria andBlogImgLike(String value) {
            addCriterion("blog_img like", value, "blogImg");
            return (Criteria) this;
        }

        public Criteria andBlogImgNotLike(String value) {
            addCriterion("blog_img not like", value, "blogImg");
            return (Criteria) this;
        }

        public Criteria andBlogImgIn(List<String> values) {
            addCriterion("blog_img in", values, "blogImg");
            return (Criteria) this;
        }

        public Criteria andBlogImgNotIn(List<String> values) {
            addCriterion("blog_img not in", values, "blogImg");
            return (Criteria) this;
        }

        public Criteria andBlogImgBetween(String value1, String value2) {
            addCriterion("blog_img between", value1, value2, "blogImg");
            return (Criteria) this;
        }

        public Criteria andBlogImgNotBetween(String value1, String value2) {
            addCriterion("blog_img not between", value1, value2, "blogImg");
            return (Criteria) this;
        }

        public Criteria andBlogStateIsNull() {
            addCriterion("blog_state is null");
            return (Criteria) this;
        }

        public Criteria andBlogStateIsNotNull() {
            addCriterion("blog_state is not null");
            return (Criteria) this;
        }

        public Criteria andBlogStateEqualTo(Byte value) {
            addCriterion("blog_state =", value, "blogState");
            return (Criteria) this;
        }

        public Criteria andBlogStateNotEqualTo(Byte value) {
            addCriterion("blog_state <>", value, "blogState");
            return (Criteria) this;
        }

        public Criteria andBlogStateGreaterThan(Byte value) {
            addCriterion("blog_state >", value, "blogState");
            return (Criteria) this;
        }

        public Criteria andBlogStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("blog_state >=", value, "blogState");
            return (Criteria) this;
        }

        public Criteria andBlogStateLessThan(Byte value) {
            addCriterion("blog_state <", value, "blogState");
            return (Criteria) this;
        }

        public Criteria andBlogStateLessThanOrEqualTo(Byte value) {
            addCriterion("blog_state <=", value, "blogState");
            return (Criteria) this;
        }

        public Criteria andBlogStateIn(List<Byte> values) {
            addCriterion("blog_state in", values, "blogState");
            return (Criteria) this;
        }

        public Criteria andBlogStateNotIn(List<Byte> values) {
            addCriterion("blog_state not in", values, "blogState");
            return (Criteria) this;
        }

        public Criteria andBlogStateBetween(Byte value1, Byte value2) {
            addCriterion("blog_state between", value1, value2, "blogState");
            return (Criteria) this;
        }

        public Criteria andBlogStateNotBetween(Byte value1, Byte value2) {
            addCriterion("blog_state not between", value1, value2, "blogState");
            return (Criteria) this;
        }

        public Criteria andAdmireStateIsNull() {
            addCriterion("admire_state is null");
            return (Criteria) this;
        }

        public Criteria andAdmireStateIsNotNull() {
            addCriterion("admire_state is not null");
            return (Criteria) this;
        }

        public Criteria andAdmireStateEqualTo(Byte value) {
            addCriterion("admire_state =", value, "admireState");
            return (Criteria) this;
        }

        public Criteria andAdmireStateNotEqualTo(Byte value) {
            addCriterion("admire_state <>", value, "admireState");
            return (Criteria) this;
        }

        public Criteria andAdmireStateGreaterThan(Byte value) {
            addCriterion("admire_state >", value, "admireState");
            return (Criteria) this;
        }

        public Criteria andAdmireStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("admire_state >=", value, "admireState");
            return (Criteria) this;
        }

        public Criteria andAdmireStateLessThan(Byte value) {
            addCriterion("admire_state <", value, "admireState");
            return (Criteria) this;
        }

        public Criteria andAdmireStateLessThanOrEqualTo(Byte value) {
            addCriterion("admire_state <=", value, "admireState");
            return (Criteria) this;
        }

        public Criteria andAdmireStateIn(List<Byte> values) {
            addCriterion("admire_state in", values, "admireState");
            return (Criteria) this;
        }

        public Criteria andAdmireStateNotIn(List<Byte> values) {
            addCriterion("admire_state not in", values, "admireState");
            return (Criteria) this;
        }

        public Criteria andAdmireStateBetween(Byte value1, Byte value2) {
            addCriterion("admire_state between", value1, value2, "admireState");
            return (Criteria) this;
        }

        public Criteria andAdmireStateNotBetween(Byte value1, Byte value2) {
            addCriterion("admire_state not between", value1, value2, "admireState");
            return (Criteria) this;
        }

        public Criteria andCommentStateIsNull() {
            addCriterion("comment_state is null");
            return (Criteria) this;
        }

        public Criteria andCommentStateIsNotNull() {
            addCriterion("comment_state is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStateEqualTo(Byte value) {
            addCriterion("comment_state =", value, "commentState");
            return (Criteria) this;
        }

        public Criteria andCommentStateNotEqualTo(Byte value) {
            addCriterion("comment_state <>", value, "commentState");
            return (Criteria) this;
        }

        public Criteria andCommentStateGreaterThan(Byte value) {
            addCriterion("comment_state >", value, "commentState");
            return (Criteria) this;
        }

        public Criteria andCommentStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("comment_state >=", value, "commentState");
            return (Criteria) this;
        }

        public Criteria andCommentStateLessThan(Byte value) {
            addCriterion("comment_state <", value, "commentState");
            return (Criteria) this;
        }

        public Criteria andCommentStateLessThanOrEqualTo(Byte value) {
            addCriterion("comment_state <=", value, "commentState");
            return (Criteria) this;
        }

        public Criteria andCommentStateIn(List<Byte> values) {
            addCriterion("comment_state in", values, "commentState");
            return (Criteria) this;
        }

        public Criteria andCommentStateNotIn(List<Byte> values) {
            addCriterion("comment_state not in", values, "commentState");
            return (Criteria) this;
        }

        public Criteria andCommentStateBetween(Byte value1, Byte value2) {
            addCriterion("comment_state between", value1, value2, "commentState");
            return (Criteria) this;
        }

        public Criteria andCommentStateNotBetween(Byte value1, Byte value2) {
            addCriterion("comment_state not between", value1, value2, "commentState");
            return (Criteria) this;
        }

        public Criteria andRecommendStateIsNull() {
            addCriterion("recommend_state is null");
            return (Criteria) this;
        }

        public Criteria andRecommendStateIsNotNull() {
            addCriterion("recommend_state is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendStateEqualTo(Byte value) {
            addCriterion("recommend_state =", value, "recommendState");
            return (Criteria) this;
        }

        public Criteria andRecommendStateNotEqualTo(Byte value) {
            addCriterion("recommend_state <>", value, "recommendState");
            return (Criteria) this;
        }

        public Criteria andRecommendStateGreaterThan(Byte value) {
            addCriterion("recommend_state >", value, "recommendState");
            return (Criteria) this;
        }

        public Criteria andRecommendStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("recommend_state >=", value, "recommendState");
            return (Criteria) this;
        }

        public Criteria andRecommendStateLessThan(Byte value) {
            addCriterion("recommend_state <", value, "recommendState");
            return (Criteria) this;
        }

        public Criteria andRecommendStateLessThanOrEqualTo(Byte value) {
            addCriterion("recommend_state <=", value, "recommendState");
            return (Criteria) this;
        }

        public Criteria andRecommendStateIn(List<Byte> values) {
            addCriterion("recommend_state in", values, "recommendState");
            return (Criteria) this;
        }

        public Criteria andRecommendStateNotIn(List<Byte> values) {
            addCriterion("recommend_state not in", values, "recommendState");
            return (Criteria) this;
        }

        public Criteria andRecommendStateBetween(Byte value1, Byte value2) {
            addCriterion("recommend_state between", value1, value2, "recommendState");
            return (Criteria) this;
        }

        public Criteria andRecommendStateNotBetween(Byte value1, Byte value2) {
            addCriterion("recommend_state not between", value1, value2, "recommendState");
            return (Criteria) this;
        }

        public Criteria andReprintStateIsNull() {
            addCriterion("reprint_state is null");
            return (Criteria) this;
        }

        public Criteria andReprintStateIsNotNull() {
            addCriterion("reprint_state is not null");
            return (Criteria) this;
        }

        public Criteria andReprintStateEqualTo(Byte value) {
            addCriterion("reprint_state =", value, "reprintState");
            return (Criteria) this;
        }

        public Criteria andReprintStateNotEqualTo(Byte value) {
            addCriterion("reprint_state <>", value, "reprintState");
            return (Criteria) this;
        }

        public Criteria andReprintStateGreaterThan(Byte value) {
            addCriterion("reprint_state >", value, "reprintState");
            return (Criteria) this;
        }

        public Criteria andReprintStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("reprint_state >=", value, "reprintState");
            return (Criteria) this;
        }

        public Criteria andReprintStateLessThan(Byte value) {
            addCriterion("reprint_state <", value, "reprintState");
            return (Criteria) this;
        }

        public Criteria andReprintStateLessThanOrEqualTo(Byte value) {
            addCriterion("reprint_state <=", value, "reprintState");
            return (Criteria) this;
        }

        public Criteria andReprintStateIn(List<Byte> values) {
            addCriterion("reprint_state in", values, "reprintState");
            return (Criteria) this;
        }

        public Criteria andReprintStateNotIn(List<Byte> values) {
            addCriterion("reprint_state not in", values, "reprintState");
            return (Criteria) this;
        }

        public Criteria andReprintStateBetween(Byte value1, Byte value2) {
            addCriterion("reprint_state between", value1, value2, "reprintState");
            return (Criteria) this;
        }

        public Criteria andReprintStateNotBetween(Byte value1, Byte value2) {
            addCriterion("reprint_state not between", value1, value2, "reprintState");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}