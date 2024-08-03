package bg.softuni.surfApp.stories.web;

import bg.softuni.surfApp.stories.model.binding.AddStoryBindingModel;
import bg.softuni.surfApp.stories.model.binding.StoryBindingModel;
import bg.softuni.surfApp.stories.service.StoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stories")
public class StoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StoryController.class);

   private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoryBindingModel> findStory(@PathVariable("id") Long id) {
       return ResponseEntity
               .ok(storyService.getStory(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StoryBindingModel> deleteStory(@PathVariable("id") Long id) {
        storyService.deleteStory(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<StoryBindingModel>> getAllStories() {
        return ResponseEntity.ok(
                storyService.getAllStories()
        );
    }

    @PostMapping
    public ResponseEntity<StoryBindingModel> createStory(
            @RequestBody AddStoryBindingModel addStoryBindingModel
    ) {
        LOGGER.info("going to create a story {}" , addStoryBindingModel);

        storyService.createStory(addStoryBindingModel);
        return ResponseEntity.ok().build();
    }

}
