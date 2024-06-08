package b.softuni.surfApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "stories")
public class StoryEntity extends BaseEntity {

    @Column(name = "creation_moment", nullable = false)
    private LocalDateTime creationMoment;
    @Column(name = "story_text", nullable = false, columnDefinition = "TEXT")
    private String storyText;

    @ManyToOne(optional = false)
    private CampEntity camp;
    @ManyToOne(optional = false)
    private UserEntity creator;

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

    public CampEntity getCamp() {
        return camp;
    }

    public void setCamp(CampEntity camp) {
        this.camp = camp;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoryEntity that = (StoryEntity) o;
        return getCreationMoment().equals(that.getCreationMoment()) && getCamp().equals(that.getCamp()) && getCreator().equals(that.getCreator());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreationMoment(), getCamp(), getCreator());
    }
}
