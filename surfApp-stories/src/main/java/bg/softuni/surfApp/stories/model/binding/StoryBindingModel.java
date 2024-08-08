package bg.softuni.surfApp.stories.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class StoryBindingModel {

        private Long id;
        private String title;
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime creationMoment;
        private String storyText;
        private String campName;
        private String authorName;
        private String originalLanguage;
    public StoryBindingModel() {}

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

    public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public StoryBindingModel setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
        return this;
    }
}


