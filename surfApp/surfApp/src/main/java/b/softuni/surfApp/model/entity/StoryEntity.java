package b.softuni.surfApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;


@Entity
@Table(name = "stories")
public class StoryEntity extends BaseEntity {

    @Column(name = "creation_moment", nullable = false)
    private LocalDateTime creationMoment;
    @Column(name = "story_text", nullable = false, columnDefinition = "TEXT")
    private String storyText;

    @Column(nullable = false)
    private String campName;
    @Column(nullable = false)
    private String creatorName;

    public StoryEntity() {}


    public LocalDateTime getCreationMoment() {
        return creationMoment;
    }

    public void setCreationMoment(LocalDateTime creationMoment) {
        this.creationMoment = creationMoment;
    }

    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
}
