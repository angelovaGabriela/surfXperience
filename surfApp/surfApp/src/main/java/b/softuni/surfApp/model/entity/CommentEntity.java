package b.softuni.surfApp.model.entity;

import b.softuni.surfApp.model.enums.MoodEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    @Column(name = "creation_moment", nullable = false)
    private LocalDateTime creationMoment;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MoodEnum mood;
    @ManyToOne(optional = false)
    private UserEntity creator;

    @Column(name = "comment_text", nullable = false,  columnDefinition = "TEXT")
    private String commentText;

    public CommentEntity() {}

    public LocalDateTime getCreationMoment() {
        return creationMoment;
    }

    public void setCreationMoment(LocalDateTime creationMoment) {
        this.creationMoment = creationMoment;
    }

    public MoodEnum getMood() {
        return mood;
    }

    public void setMood(MoodEnum mood) {
        this.mood = mood;
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
