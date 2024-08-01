package bg.softuni.surfApp.stories.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "stories")
public class StoryEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "creation_moment", nullable = false)
    private LocalDateTime creationMoment;
    @Column(name = "story_text", nullable = false, columnDefinition = "TEXT")
    private String storyText;

    @Column(nullable = false)
    private String campName;
    @Column(nullable = false)
    private String authorName;

    public StoryEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}
