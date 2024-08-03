package bg.softuni.surfApp.stories.service;

import bg.softuni.surfApp.stories.model.binding.AddStoryBindingModel;
import bg.softuni.surfApp.stories.model.binding.StoryBindingModel;

import java.util.List;

public interface StoryService {

    void createStory(AddStoryBindingModel addStoryBindingModel);

    void deleteStory(Long storyId);

    List<StoryBindingModel> getAllStories();

    StoryBindingModel getStory(Long id);
}
