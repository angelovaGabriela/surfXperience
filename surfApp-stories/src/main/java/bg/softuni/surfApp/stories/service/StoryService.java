package bg.softuni.surfApp.stories.service;

import bg.softuni.surfApp.stories.model.binding.AddStoryBindingModel;

public interface StoryService {
    long createStory(AddStoryBindingModel addStoryBindingModel);
}
