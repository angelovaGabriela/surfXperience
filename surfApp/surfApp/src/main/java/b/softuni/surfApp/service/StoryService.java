package b.softuni.surfApp.service;

import b.softuni.surfApp.model.binding.AddStoryBindingModel;

public interface StoryService {

    void createStory(AddStoryBindingModel addStoryBindingModel);

    void deleteStory(long storyId);


}
