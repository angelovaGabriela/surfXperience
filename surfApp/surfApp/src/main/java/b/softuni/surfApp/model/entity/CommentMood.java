package b.softuni.surfApp.model.entity;

import b.softuni.surfApp.model.enums.MoodEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "comment_moods")
public class CommentMood extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MoodEnum mood;


    public CommentMood() {}

    public MoodEnum getMood() {
        return mood;
    }

    public void setMood(MoodEnum mood) {
        this.mood = mood;
    }
}
