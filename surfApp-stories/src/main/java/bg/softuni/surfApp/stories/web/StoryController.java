package bg.softuni.surfApp.stories.web;

import bg.softuni.surfApp.stories.model.binding.AddStoryBindingModel;
import bg.softuni.surfApp.stories.model.binding.StoryBindingModel;
import bg.softuni.surfApp.stories.repository.StoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stories")
public class StoryController {

    private final StoryRepository storyRepository;

    public StoryController(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @PostMapping
    public ResponseEntity<StoryBindingModel> createStory(AddStoryBindingModel addStoryBindingModel) {
        return ResponseEntity.ok().build();
    }

}
