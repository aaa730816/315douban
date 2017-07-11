package main.entities;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Tony on 2017/6/30.
 */
public class Comment {
    private int commentId;
    private Date commentDate;
    private String commentCont;
    private Integer userId;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentCont() {
        return commentCont;
    }

    public void setCommentCont(String commentCont) {
        this.commentCont = commentCont;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (commentId != comment.commentId) return false;
        if (commentDate != null ? !commentDate.equals(comment.commentDate) : comment.commentDate != null) return false;
        if (commentCont != null ? !commentCont.equals(comment.commentCont) : comment.commentCont != null) return false;
        if (userId != null ? !userId.equals(comment.userId) : comment.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + (commentDate != null ? commentDate.hashCode() : 0);
        result = 31 * result + (commentCont != null ? commentCont.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
