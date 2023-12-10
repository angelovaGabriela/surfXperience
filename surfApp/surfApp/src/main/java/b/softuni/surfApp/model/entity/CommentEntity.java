package b.softuni.surfApp.model.entity;

import b.softuni.surfApp.model.enums.MoodEnum;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    private LocalDate creationDate;
    private MoodEnum mood;
    @ManyToOne
    private UserEntity creator;

    public CommentEntity() {}

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
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


}
