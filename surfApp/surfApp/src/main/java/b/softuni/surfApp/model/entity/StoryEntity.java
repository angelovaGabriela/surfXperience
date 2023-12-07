package b.softuni.surfApp.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "stories")
public class StoryEntity extends BaseEntity {

    private LocalDate creationDate;
    private String storyText;

    private CampEntity camp;
    private UserEntity creator;

    public StoryEntity() {}

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
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
}
