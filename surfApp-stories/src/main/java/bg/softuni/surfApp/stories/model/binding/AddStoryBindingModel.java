package bg.softuni.surfApp.stories.model.binding;


import java.time.LocalDateTime;

public class AddStoryBindingModel {
    private Long id;
    private LocalDateTime creationMoment;
    private String storyText;
    private String campName;
    private String creatorName;

    public AddStoryBindingModel() {}

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public LocalDateTime getCreationMoment() {
        return creationMoment;
    }

    public void setCreationMoment(LocalDateTime creationMoment) {
        this.creationMoment = creationMoment;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }
}
