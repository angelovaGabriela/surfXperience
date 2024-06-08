package b.softuni.surfApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    @Column(name = "creation_moment", nullable = false)
    private LocalDateTime creationMoment;

    @Column(name = "comment_text", nullable = false,  columnDefinition = "TEXT")
    private String commentText;
    @ManyToOne(optional = false)
    private UserEntity creator;

    @ManyToOne(optional = false)
    private CommentMood mood;
    public CommentEntity() {}

    public LocalDateTime getCreationMoment() {
        return creationMoment;
    }

    public void setCreationMoment(LocalDateTime creationMoment) {
        this.creationMoment = creationMoment;
    }


    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public CommentMood getMood() {
        return mood;
    }

    public void setMood(CommentMood mood) {
        this.mood = mood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity that = (CommentEntity) o;
        return getCreationMoment().equals(that.getCreationMoment()) && getCreator().equals(that.getCreator());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreationMoment(), getCreator());
    }

}
