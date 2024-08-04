package b.softuni.surfApp.service;

import b.softuni.surfApp.model.binding.AddStoryBindingModel;
import b.softuni.surfApp.model.view.FullStoryViewModel;
import b.softuni.surfApp.model.view.StoryViewModel;

import java.util.List;

public interface StoryService {

    void createStory(AddStoryBindingModel addStoryBindingModel);

    List<StoryViewModel> getAllStories();

    void deleteStory(long storyId);

    FullStoryViewModel fullStory(Long storyId);

}
